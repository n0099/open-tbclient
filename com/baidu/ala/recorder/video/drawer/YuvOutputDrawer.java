package com.baidu.ala.recorder.video.drawer;

import android.annotation.TargetApi;
import android.opengl.GLES20;
import com.baidu.ala.recorder.video.gles.BaseFilter;
import com.baidu.ala.recorder.video.gles.GlUtil;
import java.nio.ByteBuffer;
@TargetApi(15)
/* loaded from: classes12.dex */
public class YuvOutputDrawer extends BaseFilter {
    public static final int EXPORT_TYPE_I420 = 1;
    public static final int EXPORT_TYPE_NV12 = 3;
    public static final int EXPORT_TYPE_NV21 = 4;
    public static final int EXPORT_TYPE_YV12 = 2;
    private int[] lastViewPort;
    private BaseFilter mExportFilter;
    private ByteBuffer mOutBuffer;
    private BaseFilter mScaleFilter;

    public YuvOutputDrawer(int i) {
        super("None", "None");
        this.lastViewPort = new int[4];
        this.mExportFilter = new ExportFilter(i);
        this.mScaleFilter = new ScaleFilter();
    }

    @Override // com.baidu.ala.recorder.video.gles.BaseFilter
    public float[] getTextureMatrix() {
        return this.mExportFilter.getTextureMatrix();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.ala.recorder.video.gles.BaseFilter
    public void onCreate() {
        this.mExportFilter.create();
        this.mScaleFilter.create();
        this.mScaleFilter.setTextureCo(GlUtil.getRoate180TextureMatrix());
    }

    @Override // com.baidu.ala.recorder.video.gles.BaseFilter
    protected void onSizeChanged(int i, int i2) {
        long j = i2;
        if (j % 8 != 0) {
            i2 = (int) ((j & (-8)) + 8);
            GlUtil.logPrint("onSizeChanged height % 8 != 0");
        }
        this.mScaleFilter.sizeChanged(i, i2);
        this.mExportFilter.sizeChanged(i, i2);
        this.mOutBuffer = ByteBuffer.allocate(((this.mWidth * this.mHeight) * 3) / 2);
    }

    @Override // com.baidu.ala.recorder.video.gles.BaseFilter, com.baidu.ala.recorder.video.gles.Renderer
    public void draw(int i) {
        onTaskExec();
        boolean glIsEnabled = GLES20.glIsEnabled(3042);
        GLES20.glDisable(3042);
        GLES20.glGetIntegerv(2978, this.lastViewPort, 0);
        GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
        this.mExportFilter.draw(this.mScaleFilter.drawToTexture(i));
        GLES20.glReadPixels(0, 0, this.mWidth, (this.mHeight * 3) / 8, 6408, 5121, this.mOutBuffer);
        GLES20.glViewport(this.lastViewPort[0], this.lastViewPort[1], this.lastViewPort[2], this.lastViewPort[3]);
        if (glIsEnabled) {
            GLES20.glEnable(3042);
        }
    }

    public ByteBuffer getByteBuffer() {
        return this.mOutBuffer;
    }

    public void getOutput(byte[] bArr, int i, int i2) {
        if (this.mOutBuffer != null) {
            this.mOutBuffer.get(bArr, i, i2);
            this.mOutBuffer.clear();
        }
    }

    @Override // com.baidu.ala.recorder.video.gles.BaseFilter, com.baidu.ala.recorder.video.gles.Renderer
    public void destroy() {
        this.mExportFilter.destroy();
        this.mScaleFilter.destroy();
    }

    /* loaded from: classes12.dex */
    private static class ExportShader {
        private final String HEAD;

        private ExportShader() {
            this.HEAD = "precision highp float;\nprecision highp int;\n\nvarying vec2 vTextureCo;\nuniform sampler2D uTexture;\n\nuniform float uWidth;\nuniform float uHeight;\n\nfloat cY(float x,float y){\n    vec4 c=texture2D(uTexture,vec2(x,y));\n    return c.r*0.257+c.g*0.504+c.b*0.098+0.0625;\n}\n\nvec4 cC(float x,float y,float dx,float dy){\n    vec4 c0=texture2D(uTexture,vec2(x,y));\n    vec4 c1=texture2D(uTexture,vec2(x+dx,y));\n    vec4 c2=texture2D(uTexture,vec2(x,y+dy));\n    vec4 c3=texture2D(uTexture,vec2(x+dx,y+dy));\n    return (c0+c1+c2+c3)/4.;\n}\n\nfloat cU(float x,float y,float dx,float dy){\n    vec4 c=cC(x,y,dx,dy);\n    return -0.148*c.r - 0.291*c.g + 0.439*c.b+0.5000;\n}\n\nfloat cV(float x,float y,float dx,float dy){\n    vec4 c=cC(x,y,dx,dy);\n    return 0.439*c.r - 0.368*c.g - 0.071*c.b+0.5000;\n}\n\nvec2 cPos(float t,float shiftx,float gy){\n    vec2 pos=vec2(floor(uWidth*vTextureCo.x),floor(uHeight*gy));\n    return vec2(mod(pos.x*shiftx,uWidth),(pos.y*shiftx+floor(pos.x*shiftx/uWidth))*t);\n}\n\nvec4 calculateY(){\n    vec2 pos=cPos(1.,4.,vTextureCo.y);\n    vec4 oColor=vec4(0);\n    float textureYPos=pos.y/uHeight;\n    oColor[0]=cY(pos.x/uWidth,textureYPos);\n    oColor[1]=cY((pos.x+1.)/uWidth,textureYPos);\n    oColor[2]=cY((pos.x+2.)/uWidth,textureYPos);\n    oColor[3]=cY((pos.x+3.)/uWidth,textureYPos);\n    return oColor;\n}\nvec4 calculateU(float gy,float dx,float dy){\n    vec2 pos=cPos(2.,8.,vTextureCo.y-gy);\n    vec4 oColor=vec4(0);\n    float textureYPos=pos.y/uHeight;\n    oColor[0]= cU(pos.x/uWidth,textureYPos,dx,dy);\n    oColor[1]= cU((pos.x+2.)/uWidth,textureYPos,dx,dy);\n    oColor[2]= cU((pos.x+4.)/uWidth,textureYPos,dx,dy);\n    oColor[3]= cU((pos.x+6.)/uWidth,textureYPos,dx,dy);\n    return oColor;\n}\nvec4 calculateV(float gy,float dx,float dy){\n    vec2 pos=cPos(2.,8.,vTextureCo.y-gy);\n    vec4 oColor=vec4(0);\n    float textureYPos=pos.y/uHeight;\n    oColor[0]=cV(pos.x/uWidth,textureYPos,dx,dy);\n    oColor[1]=cV((pos.x+2.)/uWidth,textureYPos,dx,dy);\n    oColor[2]=cV((pos.x+4.)/uWidth,textureYPos,dx,dy);\n    oColor[3]=cV((pos.x+6.)/uWidth,textureYPos,dx,dy);\n    return oColor;\n}\nvec4 calculateUV(float dx,float dy){\n    vec2 pos=cPos(2.,4.,vTextureCo.y-0.2500);\n    vec4 oColor=vec4(0);\n    float textureYPos=pos.y/uHeight;\n    oColor[0]= cU(pos.x/uWidth,textureYPos,dx,dy);\n    oColor[1]= cV(pos.x/uWidth,textureYPos,dx,dy);\n    oColor[2]= cU((pos.x+2.)/uWidth,textureYPos,dx,dy);\n    oColor[3]= cV((pos.x+2.)/uWidth,textureYPos,dx,dy);\n    return oColor;\n}\nvec4 calculateVU(float dx,float dy){\n    vec2 pos=cPos(2.,4.,vTextureCo.y-0.2500);\n    vec4 oColor=vec4(0);\n    float textureYPos=pos.y/uHeight;\n    oColor[0]= cV(pos.x/uWidth,textureYPos,dx,dy);\n    oColor[1]= cU(pos.x/uWidth,textureYPos,dx,dy);\n    oColor[2]= cV((pos.x+2.)/uWidth,textureYPos,dx,dy);\n    oColor[3]= cU((pos.x+2.)/uWidth,textureYPos,dx,dy);\n    return oColor;\n}\n";
        }

        public String getFrag(int i) {
            StringBuilder sb = new StringBuilder();
            sb.append("precision highp float;\nprecision highp int;\n\nvarying vec2 vTextureCo;\nuniform sampler2D uTexture;\n\nuniform float uWidth;\nuniform float uHeight;\n\nfloat cY(float x,float y){\n    vec4 c=texture2D(uTexture,vec2(x,y));\n    return c.r*0.257+c.g*0.504+c.b*0.098+0.0625;\n}\n\nvec4 cC(float x,float y,float dx,float dy){\n    vec4 c0=texture2D(uTexture,vec2(x,y));\n    vec4 c1=texture2D(uTexture,vec2(x+dx,y));\n    vec4 c2=texture2D(uTexture,vec2(x,y+dy));\n    vec4 c3=texture2D(uTexture,vec2(x+dx,y+dy));\n    return (c0+c1+c2+c3)/4.;\n}\n\nfloat cU(float x,float y,float dx,float dy){\n    vec4 c=cC(x,y,dx,dy);\n    return -0.148*c.r - 0.291*c.g + 0.439*c.b+0.5000;\n}\n\nfloat cV(float x,float y,float dx,float dy){\n    vec4 c=cC(x,y,dx,dy);\n    return 0.439*c.r - 0.368*c.g - 0.071*c.b+0.5000;\n}\n\nvec2 cPos(float t,float shiftx,float gy){\n    vec2 pos=vec2(floor(uWidth*vTextureCo.x),floor(uHeight*gy));\n    return vec2(mod(pos.x*shiftx,uWidth),(pos.y*shiftx+floor(pos.x*shiftx/uWidth))*t);\n}\n\nvec4 calculateY(){\n    vec2 pos=cPos(1.,4.,vTextureCo.y);\n    vec4 oColor=vec4(0);\n    float textureYPos=pos.y/uHeight;\n    oColor[0]=cY(pos.x/uWidth,textureYPos);\n    oColor[1]=cY((pos.x+1.)/uWidth,textureYPos);\n    oColor[2]=cY((pos.x+2.)/uWidth,textureYPos);\n    oColor[3]=cY((pos.x+3.)/uWidth,textureYPos);\n    return oColor;\n}\nvec4 calculateU(float gy,float dx,float dy){\n    vec2 pos=cPos(2.,8.,vTextureCo.y-gy);\n    vec4 oColor=vec4(0);\n    float textureYPos=pos.y/uHeight;\n    oColor[0]= cU(pos.x/uWidth,textureYPos,dx,dy);\n    oColor[1]= cU((pos.x+2.)/uWidth,textureYPos,dx,dy);\n    oColor[2]= cU((pos.x+4.)/uWidth,textureYPos,dx,dy);\n    oColor[3]= cU((pos.x+6.)/uWidth,textureYPos,dx,dy);\n    return oColor;\n}\nvec4 calculateV(float gy,float dx,float dy){\n    vec2 pos=cPos(2.,8.,vTextureCo.y-gy);\n    vec4 oColor=vec4(0);\n    float textureYPos=pos.y/uHeight;\n    oColor[0]=cV(pos.x/uWidth,textureYPos,dx,dy);\n    oColor[1]=cV((pos.x+2.)/uWidth,textureYPos,dx,dy);\n    oColor[2]=cV((pos.x+4.)/uWidth,textureYPos,dx,dy);\n    oColor[3]=cV((pos.x+6.)/uWidth,textureYPos,dx,dy);\n    return oColor;\n}\nvec4 calculateUV(float dx,float dy){\n    vec2 pos=cPos(2.,4.,vTextureCo.y-0.2500);\n    vec4 oColor=vec4(0);\n    float textureYPos=pos.y/uHeight;\n    oColor[0]= cU(pos.x/uWidth,textureYPos,dx,dy);\n    oColor[1]= cV(pos.x/uWidth,textureYPos,dx,dy);\n    oColor[2]= cU((pos.x+2.)/uWidth,textureYPos,dx,dy);\n    oColor[3]= cV((pos.x+2.)/uWidth,textureYPos,dx,dy);\n    return oColor;\n}\nvec4 calculateVU(float dx,float dy){\n    vec2 pos=cPos(2.,4.,vTextureCo.y-0.2500);\n    vec4 oColor=vec4(0);\n    float textureYPos=pos.y/uHeight;\n    oColor[0]= cV(pos.x/uWidth,textureYPos,dx,dy);\n    oColor[1]= cU(pos.x/uWidth,textureYPos,dx,dy);\n    oColor[2]= cV((pos.x+2.)/uWidth,textureYPos,dx,dy);\n    oColor[3]= cU((pos.x+2.)/uWidth,textureYPos,dx,dy);\n    return oColor;\n}\n");
            switch (i) {
                case 1:
                    sb.append("void main() {\n    if(vTextureCo.y<0.2500){\n        gl_FragColor=calculateY();\n    }else if(vTextureCo.y<0.3125){\n        gl_FragColor=calculateU(0.2500,1./uWidth,1./uHeight);\n    }else if(vTextureCo.y<0.3750){\n        gl_FragColor=calculateV(0.3125,1./uWidth,1./uHeight);\n    }else{\n        gl_FragColor=vec4(0,0,0,0);\n    }\n}");
                    break;
                case 2:
                    sb.append("void main() {\n    if(vTextureCo.y<0.2500){\n        gl_FragColor=calculateY();\n    }else if(vTextureCo.y<0.3125){\n        gl_FragColor=calculateV(0.2500,1./uWidth,1./uHeight);\n    }else if(vTextureCo.y<0.3750){\n        gl_FragColor=calculateU(0.3125,1./uWidth,1./uHeight);\n    }else{\n        gl_FragColor=vec4(0,0,0,0);\n    }\n}");
                    break;
                case 3:
                    sb.append("void main() {\n    if(vTextureCo.y<0.2500){\n        gl_FragColor=calculateY();\n    }else if(vTextureCo.y<0.3750){\n        gl_FragColor=calculateUV(1./uWidth,1./uHeight);\n    }else{\n        gl_FragColor=vec4(0,0,0,0);\n    }\n}");
                    break;
                default:
                    sb.append("void main() {\n    if(vTextureCo.y<0.2500){\n        gl_FragColor=calculateY();\n    }else if(vTextureCo.y<0.3750){\n        gl_FragColor=calculateVU(1./uWidth,1./uHeight);\n    }else{\n        gl_FragColor=vec4(0,0,0,0);\n    }\n}");
                    break;
            }
            return sb.toString();
        }
    }

    /* loaded from: classes12.dex */
    private static class ExportFilter extends BaseFilter {
        private int mGLHeight;
        private int mGLWidth;

        public ExportFilter(int i) {
            super(BaseFilter.BASE_VERT, new ExportShader().getFrag(i));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.ala.recorder.video.gles.BaseFilter
        public void onCreate() {
            super.onCreate();
            this.mGLWidth = this.mShader.getUniformLocation("uWidth");
            this.mGLHeight = this.mShader.getUniformLocation("uHeight");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.ala.recorder.video.gles.BaseFilter
        public void onSetExpandData() {
            super.onSetExpandData();
            GLES20.glUniform1f(this.mGLWidth, this.mWidth);
            GLES20.glUniform1f(this.mGLHeight, this.mHeight);
        }
    }

    /* loaded from: classes12.dex */
    private static class ScaleFilter extends BaseFilter {
        private static final String HEAD = "precision mediump float;\n        varying vec2 vTextureCo;\n        uniform sampler2D uTexture;\n        void main() {\n            gl_FragColor = texture2D( uTexture, vTextureCo);\n        }";

        public ScaleFilter() {
            super(BaseFilter.BASE_VERT, HEAD);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.ala.recorder.video.gles.BaseFilter
        public void onCreate() {
            super.onCreate();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.ala.recorder.video.gles.BaseFilter
        public void onSetExpandData() {
            super.onSetExpandData();
        }
    }
}

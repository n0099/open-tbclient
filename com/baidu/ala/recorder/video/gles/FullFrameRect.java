package com.baidu.ala.recorder.video.gles;

import com.lemon.faceu.openglfilter.gpuimage.base.GPUImageFilter;
import java.nio.FloatBuffer;
/* loaded from: classes3.dex */
public class FullFrameRect {
    private GPUImageFilter mFilter;

    public FullFrameRect(GPUImageFilter gPUImageFilter) {
        this.mFilter = gPUImageFilter;
        this.mFilter.init();
    }

    public void onOutputSizeChanged(int i, int i2) {
        this.mFilter.onOutputSizeChanged(i, i2);
    }

    public void release(boolean z) {
        if (this.mFilter != null) {
            if (z) {
                this.mFilter.destroy();
            }
            this.mFilter = null;
        }
    }

    public GPUImageFilter getFilter() {
        return this.mFilter;
    }

    public void changeProgram(GPUImageFilter gPUImageFilter) {
        this.mFilter.destroy();
        this.mFilter = gPUImageFilter;
        this.mFilter.init();
    }

    public void drawFrame(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        this.mFilter.onDraw(i, floatBuffer, floatBuffer2);
    }
}

package com.baidu.ar.activity;

import android.app.Activity;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.ar.util.i;
import com.baidu.ar.util.l;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes3.dex */
public class SystemInfoActivity extends Activity {
    private final String a = "systemInfo.csv";
    private List<String> b;
    private Context c;
    private com.baidu.ar.external.a.a.a d;

    /* loaded from: classes3.dex */
    class a implements GLSurfaceView.Renderer {
        public final String a = null;

        a() {
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            gl10.glClear(16384);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            gl10.glClearColor(0.67885f, 0.13305f, 0.64978f, 1.0f);
            SystemInfoActivity.this.b = l.a(SystemInfoActivity.this, gl10);
        }
    }

    /* loaded from: classes3.dex */
    class b extends AsyncTask<List<String>, Void, Boolean> {
        private String b = "";

        b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:42:0x00be A[Catch: IOException -> 0x00c7, TryCatch #7 {IOException -> 0x00c7, blocks: (B:40:0x00b9, B:42:0x00be, B:44:0x00c3), top: B:68:0x00b9 }] */
        /* JADX WARN: Removed duplicated region for block: B:44:0x00c3 A[Catch: IOException -> 0x00c7, TRY_LEAVE, TryCatch #7 {IOException -> 0x00c7, blocks: (B:40:0x00b9, B:42:0x00be, B:44:0x00c3), top: B:68:0x00b9 }] */
        /* JADX WARN: Removed duplicated region for block: B:68:0x00b9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Boolean doInBackground(List<String>... listArr) {
            OutputStreamWriter outputStreamWriter;
            FileOutputStream fileOutputStream;
            BufferedWriter bufferedWriter;
            BufferedWriter bufferedWriter2;
            FileOutputStream fileOutputStream2 = null;
            File file = new File(i.b());
            if (!file.exists()) {
                file.mkdirs();
            }
            this.b = i.b() + File.separator + "systemInfo.csv";
            File file2 = new File(this.b);
            if (!file2.exists()) {
                try {
                    file2.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    outputStreamWriter = new OutputStreamWriter(fileOutputStream, "GBK");
                    try {
                        bufferedWriter = new BufferedWriter(outputStreamWriter);
                    } catch (IOException e2) {
                        e = e2;
                        bufferedWriter2 = null;
                        fileOutputStream2 = fileOutputStream;
                    } catch (Throwable th) {
                        th = th;
                        bufferedWriter = null;
                    }
                } catch (IOException e3) {
                    e = e3;
                    outputStreamWriter = null;
                    bufferedWriter2 = null;
                    fileOutputStream2 = fileOutputStream;
                } catch (Throwable th2) {
                    th = th2;
                    outputStreamWriter = null;
                    bufferedWriter = null;
                }
            } catch (IOException e4) {
                e = e4;
                outputStreamWriter = null;
                bufferedWriter2 = null;
            } catch (Throwable th3) {
                th = th3;
                outputStreamWriter = null;
                fileOutputStream = null;
                bufferedWriter = null;
            }
            try {
                bufferedWriter.write(listArr[0].get(1));
                bufferedWriter.write("\r\n");
                bufferedWriter.write(listArr[0].get(2));
                if (bufferedWriter != null) {
                    try {
                        bufferedWriter.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                if (outputStreamWriter != null) {
                    outputStreamWriter.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e6) {
                e = e6;
                fileOutputStream2 = fileOutputStream;
                bufferedWriter2 = bufferedWriter;
                try {
                    com.baidu.ar.util.b.d(e.getMessage());
                    if (bufferedWriter2 != null) {
                        try {
                            bufferedWriter2.close();
                        } catch (IOException e7) {
                            e7.printStackTrace();
                        }
                    }
                    if (outputStreamWriter != null) {
                        outputStreamWriter.close();
                    }
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                    return true;
                } catch (Throwable th4) {
                    th = th4;
                    bufferedWriter = bufferedWriter2;
                    fileOutputStream = fileOutputStream2;
                    if (bufferedWriter != null) {
                        try {
                            bufferedWriter.close();
                        } catch (IOException e8) {
                            e8.printStackTrace();
                            throw th;
                        }
                    }
                    if (outputStreamWriter != null) {
                        outputStreamWriter.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th5) {
                th = th5;
                if (bufferedWriter != null) {
                }
                if (outputStreamWriter != null) {
                }
                if (fileOutputStream != null) {
                }
                throw th;
            }
            return true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(Boolean bool) {
            Toast.makeText(SystemInfoActivity.this, "SystemInfo已保存至" + this.b, 1).show();
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.c = this;
        this.d = com.baidu.ar.external.a.a.a.a();
        FrameLayout frameLayout = new FrameLayout(this);
        ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        ViewGroup.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        final TextView textView = new TextView(this);
        Button button = new Button(this);
        button.setText("宿主登录");
        button.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.ar.activity.SystemInfoActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SystemInfoActivity.this.d.a(SystemInfoActivity.this.c)) {
                    SystemInfoActivity.this.d.a(SystemInfoActivity.this.c, new com.baidu.ar.external.a.a.b() { // from class: com.baidu.ar.activity.SystemInfoActivity.1.1
                        @Override // com.baidu.ar.external.a.a.b
                        public void a(String str, boolean z) {
                            textView.setText(z ? "已登录" : "未登录");
                        }
                    });
                }
            }
        });
        final TextView textView2 = new TextView(this);
        GLSurfaceView gLSurfaceView = new GLSurfaceView(this);
        gLSurfaceView.setEGLContextClientVersion(2);
        gLSurfaceView.setRenderer(new a());
        Button button2 = new Button(this);
        button2.setText("获取系统信息");
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.ar.activity.SystemInfoActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                textView2.setText((CharSequence) SystemInfoActivity.this.b.get(0));
                i.a(SystemInfoActivity.this.getPackageName());
                new b().execute(SystemInfoActivity.this.b);
            }
        });
        frameLayout.addView(gLSurfaceView, layoutParams2);
        linearLayout.addView(button, layoutParams2);
        linearLayout.addView(textView, layoutParams2);
        linearLayout.addView(button2, layoutParams2);
        linearLayout.addView(textView2, layoutParams2);
        frameLayout.addView(linearLayout, layoutParams2);
        setContentView(frameLayout, layoutParams);
    }
}

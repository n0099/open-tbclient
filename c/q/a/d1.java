package c.q.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.PBError;
import com.win.opensdk.core.Info;
import com.win.opensdk.image.gif2.GifImageView;
import com.win.opensdk.views.CircleProgressbar;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/* loaded from: classes9.dex */
public class d1 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean x;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b */
    public o f30329b;

    /* renamed from: c */
    public Bitmap f30330c;

    /* renamed from: d */
    public CircleProgressbar f30331d;

    /* renamed from: e */
    public e1 f30332e;

    /* renamed from: f */
    public boolean f30333f;

    /* renamed from: g */
    public int f30334g;

    /* renamed from: h */
    public int f30335h;

    /* renamed from: i */
    public boolean f30336i;

    /* renamed from: j */
    public boolean f30337j;
    public boolean k;
    public File l;
    public byte[] m;
    public n5 n;
    public File o;
    public File p;
    public File q;
    public ViewGroup r;
    public View s;
    public float t;
    public float u;
    public d6 v;
    public Handler w;

    public d1(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f30333f = false;
        this.f30334g = 5000;
        this.f30335h = 6;
        this.f30336i = false;
        this.f30337j = false;
        this.k = false;
        this.o = null;
        this.q = null;
        this.t = 0.0f;
        this.u = 0.0f;
        this.v = new d6(this);
        this.w = new h6(this, Looper.getMainLooper());
        this.a = context;
        try {
            m2.k(context, 0.0f);
            m2.o(context, 0.0f);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.f30329b = new o(context, str);
    }

    /* JADX DEBUG: Method not inlined, still used in: [c.q.a.v5.a(android.graphics.Bitmap):void, c.q.a.v5.a(com.win.opensdk.k0):void] */
    public static /* synthetic */ boolean i(d1 d1Var, boolean z) {
        d1Var.f30336i = z;
        return z;
    }

    public final void b(View view) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.t <= 0.0f || i2 <= 0) {
            return;
        }
        try {
            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(k1.win_splash_logo);
            relativeLayout.removeAllViews();
            if (this.s != null) {
                relativeLayout.addView(this.s);
            }
            View findViewById = view.findViewById(k1.win_splash_view);
            float a = r0.a(this.a, this.t);
            float C = r0.C(this.a) / 2.0f;
            if (a < C) {
                a = C;
            }
            float a2 = r0.a(this.a, this.u);
            float f2 = this.a.getResources().getDisplayMetrics().widthPixels / 2.0f;
            if (a2 < f2) {
                a2 = f2;
            }
            findViewById.setLayoutParams(new LinearLayout.LayoutParams((int) a2, (int) a));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            try {
                File file = new File(r0.e(this.a) + File.separator + "win" + File.separator + r0.D(str) + ".gif");
                this.p = file;
                if (file == null || !file.exists()) {
                    if (this.n != null && this.n.getStatus() == AsyncTask.Status.RUNNING) {
                        this.n.cancel(true);
                    }
                    n5 n5Var = new n5(this, str);
                    this.n = n5Var;
                    n5Var.execute(str);
                } else if (this.f30332e == null || this.f30337j || this.f30332e == null) {
                } else {
                    File file2 = this.p;
                    byte[] bArr = null;
                    try {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        FileInputStream fileInputStream = new FileInputStream(file2);
                        byte[] bArr2 = new byte[1024];
                        while (true) {
                            int read = fileInputStream.read(bArr2);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr2, 0, read);
                        }
                        fileInputStream.close();
                        byteArrayOutputStream.close();
                        bArr = byteArrayOutputStream.toByteArray();
                        if (file2.exists()) {
                            file2.delete();
                        }
                    } catch (FileNotFoundException e2) {
                        e2.printStackTrace();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                    this.m = bArr;
                    if (bArr != null) {
                        this.f30332e.onLoaded();
                        this.f30336i = true;
                    }
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    public final void e(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
            u uVar = this.f30329b.a;
            long countdown = (uVar == null || !uVar.f()) ? 0L : uVar.f30497c.getCountdown();
            CircleProgressbar circleProgressbar = (CircleProgressbar) view.findViewById(k1.win_splash_skip);
            this.f30331d = circleProgressbar;
            circleProgressbar.setOutLineColor(0);
            this.f30331d.setInCircleColor(Color.parseColor(this.a.getString(m1.win_cyclecolor)));
            this.f30331d.setProgressColor(Color.parseColor(this.a.getString(m1.win_cyc_process_color)));
            this.f30331d.setProgressLineWidth(this.f30335h);
            this.f30331d.setProgressType(com.win.opensdk.s2.f60892b);
            CircleProgressbar circleProgressbar2 = this.f30331d;
            if (countdown <= 0) {
                countdown = this.f30334g;
            }
            circleProgressbar2.setTimeMillis(countdown);
            this.f30331d.a();
            this.f30331d.a(1, this.v);
            this.f30333f = false;
            this.f30331d.setOnClickListener(new z5(this));
        }
    }

    public final void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.JPEG;
            File file = new File(r0.e(this.a) + File.separator + "win" + File.separator + r0.D(str) + "." + compressFormat.name().toLowerCase());
            this.l = file;
            if (!file.exists()) {
                new f4(new v5(this, compressFormat)).a(str, false);
            } else if (this.f30332e == null || this.f30337j) {
            } else {
                File file2 = this.l;
                this.f30330c = (!file2.exists() || file2.isDirectory()) ? null : BitmapFactory.decodeFile(file2.getAbsolutePath());
                this.f30332e.onLoaded();
                this.f30336i = true;
            }
        }
    }

    public void j() {
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            try {
                Info info = null;
                if (this.f30330c != null) {
                    this.f30330c.recycle();
                    this.f30330c = null;
                    File file2 = this.o;
                    if (file2 != null) {
                        try {
                            File file3 = new File(file2.getPath());
                            if (file3.exists() && file3.isFile()) {
                                file3.delete();
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }
                if (this.m != null && (file = this.q) != null) {
                    try {
                        File file4 = new File(file.getPath());
                        if (file4.exists() && file4.isFile()) {
                            file4.delete();
                        }
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
                if (this.w != null) {
                    this.w.removeCallbacksAndMessages(null);
                    this.w = null;
                }
                if (this.n != null && this.n.getStatus() == AsyncTask.Status.RUNNING) {
                    this.n.cancel(false);
                    this.n = null;
                }
                if (this.f30329b != null) {
                    u uVar = this.f30329b.a;
                    if (uVar != null && uVar.f()) {
                        info = uVar.f30497c;
                    }
                    if (info != null) {
                        y2 a = c3.a(this.a);
                        a.b(new g3(info));
                        a.m();
                    }
                    this.f30329b.a();
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            o oVar = this.f30329b;
            if (oVar == null || this.f30330c == null) {
                o oVar2 = this.f30329b;
                if (oVar2 == null || this.m == null) {
                    return false;
                }
                return oVar2.d();
            }
            return oVar.d();
        }
        return invokeV.booleanValue;
    }

    public void l() {
        long j2;
        a5 a5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (!r0.H(this.a)) {
                e1 e1Var = this.f30332e;
                if (e1Var != null) {
                    e1Var.onFail(PBError.NO_NETWORK);
                }
            } else if (this.f30329b != null) {
                this.f30336i = false;
                this.f30337j = false;
                this.k = false;
                x = false;
                Handler handler = this.w;
                Message obtain = Message.obtain();
                try {
                    j2 = m2.K(this.a) >= m2.r(this.a) ? m2.K(this.a) : m2.r(this.a);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    j2 = 2000;
                }
                handler.sendMessageDelayed(obtain, j2);
                u uVar = this.f30329b.a;
                if (uVar == null || (a5Var = uVar.f30496b) == null) {
                    return;
                }
                a5Var.g();
            }
        }
    }

    public void m(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j2) == null) {
            m2.d(this.a, j2);
        }
    }

    public void n(e1 e1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, e1Var) == null) {
            this.f30332e = e1Var;
            this.f30329b.f30424b = new j5(this);
        }
    }

    public void o(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, viewGroup) == null) {
            this.r = viewGroup;
            if (!r0.H(this.a)) {
                e1 e1Var = this.f30332e;
                if (e1Var != null) {
                    e1Var.b(PBError.NO_NETWORK);
                }
            } else if (!k()) {
                e1 e1Var2 = this.f30332e;
                if (e1Var2 != null) {
                    e1Var2.b(PBError.NO_LOAD);
                }
            } else if (this.f30329b.c().equals("image")) {
                viewGroup.removeAllViews();
                View inflate = LayoutInflater.from(this.a).inflate(l1.win_layout_win_splash, viewGroup);
                ImageView imageView = (ImageView) inflate.findViewById(k1.win_splash_iv);
                b(inflate);
                imageView.setVisibility(0);
                e(inflate);
                imageView.setImageBitmap(this.f30330c);
                this.o = this.l;
                this.f30329b.b(viewGroup, null);
            } else {
                viewGroup.removeAllViews();
                View inflate2 = LayoutInflater.from(this.a).inflate(l1.win_layout_win_splash, viewGroup);
                b(inflate2);
                GifImageView gifImageView = (GifImageView) inflate2.findViewById(k1.win_gifImageView);
                gifImageView.setVisibility(0);
                byte[] bArr = this.m;
                if (bArr != null) {
                    gifImageView.setBytes(bArr);
                    gifImageView.b();
                    this.q = this.p;
                }
                e(inflate2);
                this.f30329b.b(viewGroup, null);
            }
        }
    }
}

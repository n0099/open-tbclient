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
import com.baidu.tieba.R;
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
/* loaded from: classes3.dex */
public class d1 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean x;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public o f28933b;

    /* renamed from: c  reason: collision with root package name */
    public Bitmap f28934c;

    /* renamed from: d  reason: collision with root package name */
    public CircleProgressbar f28935d;

    /* renamed from: e  reason: collision with root package name */
    public e1 f28936e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f28937f;

    /* renamed from: g  reason: collision with root package name */
    public int f28938g;

    /* renamed from: h  reason: collision with root package name */
    public int f28939h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f28940i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f28941j;
    public boolean k;
    public File l;
    public byte[] m;
    public i5 n;
    public File o;
    public File p;
    public File q;
    public ViewGroup r;
    public View s;
    public float t;
    public float u;
    public y5 v;
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
        this.f28937f = false;
        this.f28938g = 5000;
        this.f28939h = 6;
        this.f28940i = false;
        this.f28941j = false;
        this.k = false;
        this.o = null;
        this.q = null;
        this.t = 0.0f;
        this.u = 0.0f;
        this.v = new y5(this);
        this.w = new c6(this, Looper.getMainLooper());
        this.a = context;
        try {
            h2.k(context, 0.0f);
            h2.o(context, 0.0f);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.f28933b = new o(context, str);
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [c.q.a.q5.a(android.graphics.Bitmap):void, c.q.a.q5.a(com.win.opensdk.k0):void] */
    public static /* synthetic */ boolean i(d1 d1Var, boolean z) {
        d1Var.f28940i = z;
        return z;
    }

    public final void b(View view) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.t <= 0.0f || i2 <= 0) {
            return;
        }
        try {
            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.win_splash_logo);
            relativeLayout.removeAllViews();
            if (this.s != null) {
                relativeLayout.addView(this.s);
            }
            View findViewById = view.findViewById(R.id.win_splash_view);
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
                    i5 i5Var = new i5(this, str);
                    this.n = i5Var;
                    i5Var.execute(str);
                } else if (this.f28936e == null || this.f28941j || this.f28936e == null) {
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
                        this.f28936e.onLoaded();
                        this.f28940i = true;
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
            u uVar = this.f28933b.a;
            long countdown = (uVar == null || !uVar.f()) ? 0L : uVar.f29133c.getCountdown();
            CircleProgressbar circleProgressbar = (CircleProgressbar) view.findViewById(R.id.win_splash_skip);
            this.f28935d = circleProgressbar;
            circleProgressbar.setOutLineColor(0);
            this.f28935d.setInCircleColor(Color.parseColor(this.a.getString(R.string.win_cyclecolor)));
            this.f28935d.setProgressColor(Color.parseColor(this.a.getString(R.string.win_cyc_process_color)));
            this.f28935d.setProgressLineWidth(this.f28939h);
            this.f28935d.setProgressType(com.win.opensdk.s2.f59409b);
            CircleProgressbar circleProgressbar2 = this.f28935d;
            if (countdown <= 0) {
                countdown = this.f28938g;
            }
            circleProgressbar2.setTimeMillis(countdown);
            this.f28935d.a();
            this.f28935d.a(1, this.v);
            this.f28937f = false;
            this.f28935d.setOnClickListener(new u5(this));
        }
    }

    public final void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.JPEG;
            File file = new File(r0.e(this.a) + File.separator + "win" + File.separator + r0.D(str) + "." + compressFormat.name().toLowerCase());
            this.l = file;
            if (!file.exists()) {
                new a4(new q5(this, compressFormat)).a(str, false);
            } else if (this.f28936e == null || this.f28941j) {
            } else {
                File file2 = this.l;
                this.f28934c = (!file2.exists() || file2.isDirectory()) ? null : BitmapFactory.decodeFile(file2.getAbsolutePath());
                this.f28936e.onLoaded();
                this.f28940i = true;
            }
        }
    }

    public void j() {
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            try {
                Info info = null;
                if (this.f28934c != null) {
                    this.f28934c.recycle();
                    this.f28934c = null;
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
                if (this.f28933b != null) {
                    u uVar = this.f28933b.a;
                    if (uVar != null && uVar.f()) {
                        info = uVar.f29133c;
                    }
                    if (info != null) {
                        t2 a = x2.a(this.a);
                        a.b(new b3(info));
                        a.m();
                    }
                    this.f28933b.a();
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
            o oVar = this.f28933b;
            if (oVar == null || this.f28934c == null) {
                o oVar2 = this.f28933b;
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
        v4 v4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (!r0.H(this.a)) {
                e1 e1Var = this.f28936e;
                if (e1Var != null) {
                    e1Var.onFail(PBError.NO_NETWORK);
                }
            } else if (this.f28933b != null) {
                this.f28940i = false;
                this.f28941j = false;
                this.k = false;
                x = false;
                Handler handler = this.w;
                Message obtain = Message.obtain();
                try {
                    j2 = h2.K(this.a) >= h2.r(this.a) ? h2.K(this.a) : h2.r(this.a);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    j2 = 2000;
                }
                handler.sendMessageDelayed(obtain, j2);
                u uVar = this.f28933b.a;
                if (uVar == null || (v4Var = uVar.f29132b) == null) {
                    return;
                }
                v4Var.g();
            }
        }
    }

    public void m(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j2) == null) {
            h2.d(this.a, j2);
        }
    }

    public void n(e1 e1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, e1Var) == null) {
            this.f28936e = e1Var;
            this.f28933b.f29050b = new e5(this);
        }
    }

    public void o(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, viewGroup) == null) {
            this.r = viewGroup;
            if (!r0.H(this.a)) {
                e1 e1Var = this.f28936e;
                if (e1Var != null) {
                    e1Var.b(PBError.NO_NETWORK);
                }
            } else if (!k()) {
                e1 e1Var2 = this.f28936e;
                if (e1Var2 != null) {
                    e1Var2.b(PBError.NO_LOAD);
                }
            } else if (this.f28933b.c().equals("image")) {
                viewGroup.removeAllViews();
                View inflate = LayoutInflater.from(this.a).inflate(R.layout.win_layout_win_splash, viewGroup);
                ImageView imageView = (ImageView) inflate.findViewById(R.id.win_splash_iv);
                b(inflate);
                imageView.setVisibility(0);
                e(inflate);
                imageView.setImageBitmap(this.f28934c);
                this.o = this.l;
                this.f28933b.b(viewGroup, null);
            } else {
                viewGroup.removeAllViews();
                View inflate2 = LayoutInflater.from(this.a).inflate(R.layout.win_layout_win_splash, viewGroup);
                b(inflate2);
                GifImageView gifImageView = (GifImageView) inflate2.findViewById(R.id.win_gifImageView);
                gifImageView.setVisibility(0);
                byte[] bArr = this.m;
                if (bArr != null) {
                    gifImageView.setBytes(bArr);
                    gifImageView.b();
                    this.q = this.p;
                }
                e(inflate2);
                this.f28933b.b(viewGroup, null);
            }
        }
    }
}

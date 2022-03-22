package c.m.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import com.win.opensdk.PBError;
import com.win.opensdk.core.Info;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class b1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public z2 f23403b;

    /* renamed from: c  reason: collision with root package name */
    public c1 f23404c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f23405d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f23406e;

    /* renamed from: f  reason: collision with root package name */
    public z3 f23407f;

    /* renamed from: g  reason: collision with root package name */
    public File f23408g;

    /* renamed from: h  reason: collision with root package name */
    public VideoView f23409h;
    public View i;
    public View j;
    public Handler k;

    public b1(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23405d = false;
        this.f23406e = false;
        this.k = new p4(this, Looper.getMainLooper());
        this.a = context;
        try {
            h2.c(context, 0.0f);
            SharedPreferences.Editor edit = context.getSharedPreferences("_prefs", 0).edit();
            edit.putFloat("draw_video_width", 0.0f);
            edit.apply();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.f23403b = new z2(context, str);
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                if (this.f23403b != null) {
                    r0.o(this.f23403b.b(), 401, "");
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            try {
                File file = new File(r0.e(this.a) + File.separator + "win" + File.separator + r0.D(str) + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION);
                this.f23408g = file;
                if (file == null || !file.exists()) {
                    if (this.f23407f != null && this.f23407f.getStatus() == AsyncTask.Status.RUNNING) {
                        this.f23407f.cancel(true);
                    }
                    z3 z3Var = new z3(this, System.currentTimeMillis(), str);
                    this.f23407f = z3Var;
                    z3Var.execute(str);
                } else if (this.f23404c == null || this.f23406e || this.f23404c == null || !this.f23408g.exists()) {
                } else {
                    t2 a = x2.a(this.a);
                    a.e(new b3(this.f23403b.b()), 201, 0L);
                    a.m();
                    this.f23404c.onLoaded();
                    this.f23405d = true;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void f() {
        File file;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (file = this.f23408g) == null || TextUtils.isEmpty(file.getPath()) || this.f23409h == null || TextUtils.isEmpty(this.f23408g.getPath())) {
            return;
        }
        this.f23409h.setOnPreparedListener(new l4(this));
        this.f23409h.setVideoPath(this.f23408g.getPath());
        this.f23409h.seekTo(0);
        this.f23409h.requestFocus();
        this.f23409h.start();
        a();
    }

    public void h() {
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            try {
                if (this.f23408g != null && !TextUtils.isEmpty(this.f23408g.getPath()) && (file = this.f23408g) != null) {
                    try {
                        File file2 = new File(file.getPath());
                        if (file2.exists() && file2.isFile()) {
                            file2.delete();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                if (this.f23409h != null) {
                    this.f23409h.stopPlayback();
                    this.f23409h.setOnCompletionListener(null);
                    this.f23409h.setOnPreparedListener(null);
                    this.f23409h = null;
                }
                if (this.k != null) {
                    this.k.removeCallbacksAndMessages(null);
                    this.k = null;
                }
                if (this.f23407f != null && this.f23407f.getStatus() == AsyncTask.Status.RUNNING) {
                    this.f23407f.cancel(false);
                    this.f23407f = null;
                }
                if (this.f23403b != null) {
                    Info b2 = this.f23403b.b();
                    if (b2 != null) {
                        t2 a = x2.a(this.a);
                        a.b(new b3(b2));
                        a.m();
                    }
                    this.f23403b.a();
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    public View i() {
        InterceptResult invokeV;
        z2 z2Var;
        Info b2;
        p2 p2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            z2 z2Var2 = this.f23403b;
            if ((z2Var2 == null || (p2Var = z2Var2.a) == null || !p2Var.e()) ? false : true) {
                p2 p2Var2 = this.f23403b.a;
                if (((p2Var2 == null || !p2Var2.e()) ? "" : p2Var2.f23529c.getLoad_type()).equals("video")) {
                    View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d08db, (ViewGroup) null);
                    this.i = inflate;
                    VideoView videoView = (VideoView) inflate.findViewById(R.id.obfuscated_res_0x7f092474);
                    this.f23409h = videoView;
                    videoView.setVisibility(0);
                    this.f23409h.setOnErrorListener(new d4(this));
                    f();
                    ArrayList arrayList = new ArrayList();
                    arrayList.clear();
                    View view = this.i;
                    if (view != null) {
                        View findViewById = view.findViewById(R.id.obfuscated_res_0x7f092483);
                        this.j = findViewById;
                        arrayList.add(findViewById);
                    }
                    if (this.i != null && (z2Var = this.f23403b) != null && (b2 = z2Var.b()) != null) {
                        ((TextView) this.i.findViewById(R.id.obfuscated_res_0x7f092478)).setText(b2.getTitle());
                        ((TextView) this.i.findViewById(R.id.obfuscated_res_0x7f092476)).setText(b2.getDesc());
                        ((TextView) this.i.findViewById(R.id.obfuscated_res_0x7f09247a)).setText(b2.getBtndesc());
                        ImageView imageView = (ImageView) this.i.findViewById(R.id.obfuscated_res_0x7f092477);
                        String icon = b2.getIcon();
                        if (!TextUtils.isEmpty(icon)) {
                            new a4(new t4(this, imageView)).a(icon, false);
                        }
                    }
                    z2 z2Var3 = this.f23403b;
                    View view2 = this.i;
                    p2 p2Var3 = z2Var3.a;
                    if (p2Var3 != null) {
                        p2Var3.b(view2, null, arrayList);
                    }
                    Handler handler = this.k;
                    if (handler != null) {
                        handler.postDelayed(new h4(this), 3000L);
                    }
                }
                return this.i;
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public void j() {
        Handler handler;
        v4 v4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (!r0.H(this.a)) {
                c1 c1Var = this.f23404c;
                if (c1Var != null) {
                    c1Var.onFail(PBError.NO_NETWORK);
                }
            } else if (this.f23403b == null || (handler = this.k) == null) {
            } else {
                this.f23405d = false;
                this.f23406e = false;
                Message obtain = Message.obtain();
                long u = h2.u(this.a);
                if (u <= 10000) {
                    u = 10000;
                }
                handler.sendMessageDelayed(obtain, u);
                p2 p2Var = this.f23403b.a;
                if (p2Var == null || (v4Var = p2Var.f23528b) == null) {
                    return;
                }
                v4Var.g();
            }
        }
    }

    public void k(c1 c1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, c1Var) == null) {
            this.f23404c = c1Var;
            this.f23403b.f23612b = new k3(this);
        }
    }
}

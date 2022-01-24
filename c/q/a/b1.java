package c.q.a;

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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.PBError;
import com.win.opensdk.core.Info;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class b1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public e3 f30309b;

    /* renamed from: c  reason: collision with root package name */
    public c1 f30310c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f30311d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f30312e;

    /* renamed from: f  reason: collision with root package name */
    public e4 f30313f;

    /* renamed from: g  reason: collision with root package name */
    public File f30314g;

    /* renamed from: h  reason: collision with root package name */
    public VideoView f30315h;

    /* renamed from: i  reason: collision with root package name */
    public View f30316i;

    /* renamed from: j  reason: collision with root package name */
    public View f30317j;
    public Handler k;

    public b1(Context context, String str) {
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
        this.f30311d = false;
        this.f30312e = false;
        this.k = new u4(this, Looper.getMainLooper());
        this.a = context;
        try {
            m2.c(context, 0.0f);
            SharedPreferences.Editor edit = context.getSharedPreferences("_prefs", 0).edit();
            edit.putFloat("draw_video_width", 0.0f);
            edit.apply();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.f30309b = new e3(context, str);
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                if (this.f30309b != null) {
                    r0.o(this.f30309b.b(), 401, "");
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
                File file = new File(r0.e(this.a) + File.separator + "win" + File.separator + r0.D(str) + ".mp4");
                this.f30314g = file;
                if (file == null || !file.exists()) {
                    if (this.f30313f != null && this.f30313f.getStatus() == AsyncTask.Status.RUNNING) {
                        this.f30313f.cancel(true);
                    }
                    e4 e4Var = new e4(this, System.currentTimeMillis(), str);
                    this.f30313f = e4Var;
                    e4Var.execute(str);
                } else if (this.f30310c == null || this.f30312e || this.f30310c == null || !this.f30314g.exists()) {
                } else {
                    y2 a = c3.a(this.a);
                    a.e(new g3(this.f30309b.b()), 201, 0L);
                    a.m();
                    this.f30310c.onLoaded();
                    this.f30311d = true;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void f() {
        File file;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (file = this.f30314g) == null || TextUtils.isEmpty(file.getPath()) || this.f30315h == null || TextUtils.isEmpty(this.f30314g.getPath())) {
            return;
        }
        this.f30315h.setOnPreparedListener(new q4(this));
        this.f30315h.setVideoPath(this.f30314g.getPath());
        this.f30315h.seekTo(0);
        this.f30315h.requestFocus();
        this.f30315h.start();
        a();
    }

    public void h() {
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            try {
                if (this.f30314g != null && !TextUtils.isEmpty(this.f30314g.getPath()) && (file = this.f30314g) != null) {
                    try {
                        File file2 = new File(file.getPath());
                        if (file2.exists() && file2.isFile()) {
                            file2.delete();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                if (this.f30315h != null) {
                    this.f30315h.stopPlayback();
                    this.f30315h.setOnCompletionListener(null);
                    this.f30315h.setOnPreparedListener(null);
                    this.f30315h = null;
                }
                if (this.k != null) {
                    this.k.removeCallbacksAndMessages(null);
                    this.k = null;
                }
                if (this.f30313f != null && this.f30313f.getStatus() == AsyncTask.Status.RUNNING) {
                    this.f30313f.cancel(false);
                    this.f30313f = null;
                }
                if (this.f30309b != null) {
                    Info b2 = this.f30309b.b();
                    if (b2 != null) {
                        y2 a = c3.a(this.a);
                        a.b(new g3(b2));
                        a.m();
                    }
                    this.f30309b.a();
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    public View i() {
        InterceptResult invokeV;
        e3 e3Var;
        Info b2;
        u2 u2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            e3 e3Var2 = this.f30309b;
            if ((e3Var2 == null || (u2Var = e3Var2.a) == null || !u2Var.e()) ? false : true) {
                u2 u2Var2 = this.f30309b.a;
                if (((u2Var2 == null || !u2Var2.e()) ? "" : u2Var2.f30511c.getLoad_type()).equals("video")) {
                    View inflate = LayoutInflater.from(this.a).inflate(l1.win_layout_win_draw_video, (ViewGroup) null);
                    this.f30316i = inflate;
                    VideoView videoView = (VideoView) inflate.findViewById(k1.win_ad_video_view);
                    this.f30315h = videoView;
                    videoView.setVisibility(0);
                    this.f30315h.setOnErrorListener(new i4(this));
                    f();
                    ArrayList arrayList = new ArrayList();
                    arrayList.clear();
                    View view = this.f30316i;
                    if (view != null) {
                        View findViewById = view.findViewById(k1.win_layout_draw_ad_card);
                        this.f30317j = findViewById;
                        arrayList.add(findViewById);
                    }
                    if (this.f30316i != null && (e3Var = this.f30309b) != null && (b2 = e3Var.b()) != null) {
                        ((TextView) this.f30316i.findViewById(k1.win_card_app_name)).setText(b2.getTitle());
                        ((TextView) this.f30316i.findViewById(k1.win_card_app_desc)).setText(b2.getDesc());
                        ((TextView) this.f30316i.findViewById(k1.win_card_h5_open_btn)).setText(b2.getBtndesc());
                        ImageView imageView = (ImageView) this.f30316i.findViewById(k1.win_card_app_icon);
                        String icon = b2.getIcon();
                        if (!TextUtils.isEmpty(icon)) {
                            new f4(new y4(this, imageView)).a(icon, false);
                        }
                    }
                    e3 e3Var3 = this.f30309b;
                    View view2 = this.f30316i;
                    u2 u2Var3 = e3Var3.a;
                    if (u2Var3 != null) {
                        u2Var3.b(view2, null, arrayList);
                    }
                    Handler handler = this.k;
                    if (handler != null) {
                        handler.postDelayed(new m4(this), 3000L);
                    }
                }
                return this.f30316i;
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public void j() {
        Handler handler;
        a5 a5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (!r0.H(this.a)) {
                c1 c1Var = this.f30310c;
                if (c1Var != null) {
                    c1Var.onFail(PBError.NO_NETWORK);
                }
            } else if (this.f30309b == null || (handler = this.k) == null) {
            } else {
                this.f30311d = false;
                this.f30312e = false;
                Message obtain = Message.obtain();
                long u = m2.u(this.a);
                if (u <= 10000) {
                    u = 10000;
                }
                handler.sendMessageDelayed(obtain, u);
                u2 u2Var = this.f30309b.a;
                if (u2Var == null || (a5Var = u2Var.f30510b) == null) {
                    return;
                }
                a5Var.g();
            }
        }
    }

    public void k(c1 c1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, c1Var) == null) {
            this.f30310c = c1Var;
            this.f30309b.f30340b = new p3(this);
        }
    }
}

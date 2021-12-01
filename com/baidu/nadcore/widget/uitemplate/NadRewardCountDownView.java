package com.baidu.nadcore.widget.uitemplate;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.b0.d0.d;
import c.a.b0.p.o;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.widget.uitemplate.NadRewardStayDialog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class NadRewardCountDownView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int COUNT_DOWNING = 1;
    public static final int COUNT_DOWN_CAN_CLOSE = 3;
    public static final int COUNT_DOWN_CAN_SKIP = 2;
    public static final int COUNT_DOWN_FINISH = 4;
    public static final long DEFAULT_COUNT_DOWN_INTERVAL = 1000;
    public static final int DEFAULT_TAIL_TIME = 3;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f37941e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f37942f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f37943g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.b0.d0.d f37944h;

    /* renamed from: i  reason: collision with root package name */
    public int f37945i;

    /* renamed from: j  reason: collision with root package name */
    public int f37946j;

    /* renamed from: k  reason: collision with root package name */
    public int f37947k;
    public String l;
    public String m;
    public String n;
    public int o;
    public g p;
    public NadRewardStayDialog q;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NadRewardCountDownView f37948e;

        public a(NadRewardCountDownView nadRewardCountDownView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardCountDownView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37948e = nadRewardCountDownView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f37948e.o == 1) {
                return;
            }
            if (this.f37948e.o != 2) {
                if (this.f37948e.o != 3 || this.f37948e.p == null) {
                    return;
                }
                this.f37948e.p.e();
                return;
            }
            this.f37948e.pause();
            if (this.f37948e.q != null) {
                c.a.b0.d0.a.b(this.f37948e.q);
                if (this.f37948e.p != null) {
                    this.f37948e.p.c();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NadRewardCountDownView f37949e;

        public b(NadRewardCountDownView nadRewardCountDownView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardCountDownView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37949e = nadRewardCountDownView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f37949e.o == 4 && this.f37949e.p != null) {
                this.f37949e.p.d();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends d.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadRewardCountDownView a;

        public c(NadRewardCountDownView nadRewardCountDownView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardCountDownView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadRewardCountDownView;
        }

        @Override // c.a.b0.d0.d.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.b();
                if (this.a.o < 3) {
                    NadRewardCountDownView nadRewardCountDownView = this.a;
                    nadRewardCountDownView.m = "恭喜您已获得" + this.a.l + "!";
                    this.a.o = 3;
                }
                if (this.a.f37942f.getVisibility() != 0) {
                    this.a.f37942f.setVisibility(0);
                }
                this.a.f37941e.setText(String.format(this.a.m, Integer.valueOf(this.a.f37946j)));
                this.a.invalidate();
            }
        }

        @Override // c.a.b0.d0.d.c
        public void f(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
                super.f(j2);
                this.a.f37946j = (((int) j2) / 1000) + 1;
                if (this.a.o < 2 && this.a.f37947k > 0 && this.a.f37945i - this.a.f37946j > this.a.f37947k) {
                    if (this.a.f37942f.getVisibility() != 0) {
                        this.a.f37942f.setVisibility(0);
                    }
                    this.a.o = 2;
                }
                this.a.f37941e.setText(String.format(this.a.m, Integer.valueOf(this.a.f37946j)));
                this.a.invalidate();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements NadRewardStayDialog.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadRewardCountDownView a;

        public d(NadRewardCountDownView nadRewardCountDownView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardCountDownView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadRewardCountDownView;
        }

        @Override // com.baidu.nadcore.widget.uitemplate.NadRewardStayDialog.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.q.dismiss();
                if (z && this.a.p != null) {
                    this.a.p.a();
                }
                this.a.resume();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NadRewardCountDownView f37950e;

        public e(NadRewardCountDownView nadRewardCountDownView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardCountDownView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37950e = nadRewardCountDownView;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) || this.f37950e.p == null) {
                return;
            }
            this.f37950e.p.f();
        }
    }

    /* loaded from: classes8.dex */
    public class f extends d.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadRewardCountDownView a;

        public f(NadRewardCountDownView nadRewardCountDownView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardCountDownView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadRewardCountDownView;
        }

        @Override // c.a.b0.d0.d.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.b();
                if (this.a.o != 4) {
                    this.a.n = "";
                    this.a.o = 4;
                }
                this.a.f37943g.setText(this.a.n);
                this.a.f37943g.setBackground(this.a.getResources().getDrawable(c.a.b0.b.d.nad_reward_close_icon_bg));
                this.a.requestLayout();
            }
        }

        @Override // c.a.b0.d0.d.c
        public void f(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
                super.f(j2);
                this.a.f37946j = (((int) j2) / 1000) + 1;
                this.a.f37943g.setText(String.format(this.a.n, Integer.valueOf(this.a.f37946j)));
                this.a.invalidate();
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface g {
        void a();

        void b();

        void c();

        void d();

        void e();

        void f();

        void g();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NadRewardCountDownView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void cancel() {
        c.a.b0.d0.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (dVar = this.f37944h) == null) {
            return;
        }
        dVar.b();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchWindowVisibilityChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            super.dispatchWindowVisibilityChanged(i2);
            boolean z = i2 == 0;
            if (z) {
                resume();
            }
            if (z) {
                return;
            }
            pause();
        }
    }

    public void pause() {
        c.a.b0.d0.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (dVar = this.f37944h) == null) {
            return;
        }
        dVar.d();
        g gVar = this.p;
        if (gVar != null) {
            gVar.g();
        }
    }

    public final void q(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            LayoutInflater.from(context).inflate(c.a.b0.b.g.nad_reward_count_down_view, (ViewGroup) this, true);
            TextView textView = (TextView) findViewById(c.a.b0.b.e.nad_skip_view);
            this.f37942f = textView;
            textView.setText("跳过");
            this.f37942f.setVisibility(8);
            this.f37941e = (TextView) findViewById(c.a.b0.b.e.nad_count_down_view);
            this.f37943g = (TextView) findViewById(c.a.b0.b.e.nad_tail_count_down_view);
            this.f37941e.setClickable(true);
            this.f37942f.setOnClickListener(new a(this));
            this.f37943g.setOnClickListener(new b(this));
            setVisibility(8);
        }
    }

    public void release() {
        c.a.b0.d0.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (dVar = this.f37944h) == null) {
            return;
        }
        dVar.b();
        this.f37944h = null;
    }

    public void resume() {
        c.a.b0.d0.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (dVar = this.f37944h) == null) {
            return;
        }
        dVar.e();
        g gVar = this.p;
        if (gVar != null) {
            gVar.b();
        }
    }

    public void setRewardDownInnerListener(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, gVar) == null) {
            this.p = gVar;
        }
    }

    public void start() {
        c.a.b0.d0.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (dVar = this.f37944h) == null) {
            return;
        }
        dVar.g();
    }

    public void startTailFrameCountDown() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            release();
            this.f37942f.setVisibility(8);
            this.f37941e.setVisibility(8);
            this.f37943g.setVisibility(0);
            c.a.b0.d0.d dVar = new c.a.b0.d0.d(3000L, 1000L);
            this.f37944h = dVar;
            dVar.f(new f(this));
            this.f37944h.g();
        }
    }

    public void update(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, adBaseModel) == null) || adBaseModel == null || adBaseModel.f37578h == null) {
            return;
        }
        setTag(adBaseModel);
        o oVar = adBaseModel.l;
        float f2 = 1.0f;
        if (oVar != null) {
            this.f37947k = oVar.f1803c;
            String str = oVar.f1807g;
            if (!TextUtils.isEmpty(str) && str.length() <= 4) {
                this.l = str;
                this.m = "%2ss后可以领取" + this.l;
            }
            float f3 = adBaseModel.l.f1805e;
            if (f3 > 0.0f && f3 <= 1.0f) {
                f2 = f3;
            }
        }
        int floor = (int) Math.floor(adBaseModel.f37578h.a * f2);
        this.f37945i = floor;
        this.f37946j = floor;
        c.a.b0.d0.d dVar = new c.a.b0.d0.d(floor * 1000, 1000L);
        this.f37944h = dVar;
        dVar.f(new c(this));
        NadRewardStayDialog nadRewardStayDialog = new NadRewardStayDialog(getContext(), adBaseModel, new d(this));
        this.q = nadRewardStayDialog;
        nadRewardStayDialog.setOnDismissListener(new e(this));
        this.f37941e.setVisibility(0);
        setVisibility(0);
        this.f37944h.g();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NadRewardCountDownView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NadRewardCountDownView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f37947k = -1;
        this.l = "奖励";
        this.m = "%2ss后可以领取" + this.l;
        this.n = "%2ss";
        this.o = 1;
        q(context);
    }
}

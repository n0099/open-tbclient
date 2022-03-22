package com.baidu.swan.apps.view.menu;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.n0.a.p2.q0;
import c.a.n0.a.p2.t;
import c.a.n0.a.v0.e.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.view.SwanAppRoundedImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class SwanAppMenuHeaderView extends FrameLayout implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;

    /* renamed from: b  reason: collision with root package name */
    public SwanAppRoundedImageView f29355b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f29356c;

    /* renamed from: d  reason: collision with root package name */
    public View f29357d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f29358e;

    /* renamed from: f  reason: collision with root package name */
    public e f29359f;

    /* renamed from: g  reason: collision with root package name */
    public f f29360g;

    /* renamed from: h  reason: collision with root package name */
    public e f29361h;
    public int i;
    public int j;
    public boolean k;
    public int l;
    public int m;
    public Runnable n;

    /* loaded from: classes4.dex */
    public class a implements t.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppMenuHeaderView a;

        public a(SwanAppMenuHeaderView swanAppMenuHeaderView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppMenuHeaderView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppMenuHeaderView;
        }

        @Override // c.a.n0.a.p2.t.b
        public void a(String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, bitmap) == null) || bitmap == null || this.a.f29355b == null) {
                return;
            }
            this.a.f29355b.setImageBitmap(bitmap);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppMenuHeaderView a;

        public b(SwanAppMenuHeaderView swanAppMenuHeaderView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppMenuHeaderView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppMenuHeaderView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.f29359f == null) {
                return;
            }
            this.a.f29359f.onClick(view);
            view.setPressed(true);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppMenuHeaderView a;

        public c(SwanAppMenuHeaderView swanAppMenuHeaderView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppMenuHeaderView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppMenuHeaderView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.f29361h == null) {
                return;
            }
            this.a.f29361h.onClick(view);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppMenuHeaderView a;

        public d(SwanAppMenuHeaderView swanAppMenuHeaderView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppMenuHeaderView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppMenuHeaderView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.f29360g == null) {
                return;
            }
            SwanAppMenuHeaderView swanAppMenuHeaderView = this.a;
            swanAppMenuHeaderView.k = swanAppMenuHeaderView.f29360g.onLongClick(this.a.f29357d);
        }
    }

    /* loaded from: classes4.dex */
    public interface e {
        void onClick(View view);
    }

    /* loaded from: classes4.dex */
    public interface f {
        boolean onLongClick(View view);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SwanAppMenuHeaderView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void g(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            this.f29357d = view.findViewById(R.id.obfuscated_res_0x7f090d36);
            this.f29355b = (SwanAppRoundedImageView) view.findViewById(R.id.obfuscated_res_0x7f091dee);
            this.a = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091df2);
            this.f29358e = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090417);
            this.f29356c = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f09029e);
            b.a V = c.a.n0.a.t1.d.J().r().V();
            this.f29355b.setImageBitmap(q0.k(V.Q(), "SwanAppMenuHeaderView", false, new a(this)));
            this.a.setText(V.K());
            this.a.setMaxWidth(getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070631));
            if (q0.P()) {
                this.f29356c.setVisibility(0);
                this.a.setMaxWidth(getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070633));
            }
            this.f29357d.setOnTouchListener(this);
            this.f29357d.setOnClickListener(new b(this));
            this.f29358e.setOnClickListener(new c(this));
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 2 && (Math.abs(this.l - x) > 10.0f || Math.abs(this.m - y) > 10.0f)) {
                    return true;
                }
            } else {
                this.l = (int) x;
                this.m = (int) y;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, motionEvent)) == null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1) {
                    removeCallbacks(this.n);
                    if (!this.k && (eVar = this.f29359f) != null) {
                        eVar.onClick(this.f29357d);
                    }
                    this.k = false;
                    view.setPressed(false);
                    return false;
                } else if (action != 2) {
                    if (action == 3) {
                        removeCallbacks(this.n);
                        this.k = false;
                        view.setPressed(false);
                    }
                } else if (Math.abs(this.i - x) > 10 || Math.abs(this.j - y) > 10) {
                    removeCallbacks(this.n);
                    this.k = false;
                }
            } else if (this.f29360g == null) {
                return super.onTouchEvent(motionEvent);
            } else {
                removeCallbacks(this.n);
                this.k = false;
                this.i = x;
                this.j = y;
                postDelayed(this.n, 3000L);
                view.setPressed(true);
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public void setAttentionBtnShow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f29358e.setVisibility(z ? 0 : 8);
        }
    }

    public void setAttentionBtnStates(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            if (c.a.n0.a.s0.a.y0().d()) {
                this.f29358e.setText(R.string.obfuscated_res_0x7f0f0156);
                this.f29358e.setBackground(c.a.n0.r.a.b.a.d(getContext(), R.drawable.obfuscated_res_0x7f081181));
                this.f29358e.setTextColor(c.a.n0.r.a.b.a.b(getContext(), R.color.obfuscated_res_0x7f060a7f));
            } else if (!z) {
                this.f29358e.setText(R.string.obfuscated_res_0x7f0f0156);
                this.f29358e.setTypeface(Typeface.create("sans-serif-medium", 1));
                this.f29358e.setBackground(c.a.n0.r.a.b.a.d(getContext(), R.drawable.obfuscated_res_0x7f081155));
                this.f29358e.setTextColor(c.a.n0.r.a.b.a.c(getContext(), R.color.obfuscated_res_0x7f060a6e));
            } else {
                this.f29358e.setText(R.string.obfuscated_res_0x7f0f128b);
                this.f29358e.setTypeface(Typeface.create("sans-serif", 0));
                this.f29358e.setBackground(c.a.n0.r.a.b.a.d(getContext(), R.drawable.obfuscated_res_0x7f08115c));
                this.f29358e.setTextColor(c.a.n0.r.a.b.a.c(getContext(), R.color.obfuscated_res_0x7f060a6f));
            }
        }
    }

    public void setOnAttentionBtnClickListener(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, eVar) == null) {
            this.f29361h = eVar;
        }
    }

    public void setOnMenuHeaderClickListener(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, eVar) == null) {
            this.f29359f = eVar;
        }
    }

    public void setOnMenuHeaderLongClickListener(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, fVar) == null) {
            this.f29360g = fVar;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SwanAppMenuHeaderView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwanAppMenuHeaderView(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.k = false;
        this.n = new d(this);
        g(FrameLayout.inflate(context, R.layout.obfuscated_res_0x7f0d07c3, this));
        setAttentionBtnStates(c.a.n0.a.z.b.a.n(c.a.n0.a.t1.d.J().getAppId()));
    }
}

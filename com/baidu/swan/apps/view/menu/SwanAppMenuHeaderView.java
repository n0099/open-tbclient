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
import androidx.core.graphics.TypefaceCompatApi28Impl;
import b.a.p0.a.f1.e.b;
import b.a.p0.a.g;
import b.a.p0.a.h;
import b.a.p0.a.z2.q0;
import b.a.p0.a.z2.t;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.view.SwanAppRoundedImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class SwanAppMenuHeaderView extends FrameLayout implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f45174e;

    /* renamed from: f  reason: collision with root package name */
    public SwanAppRoundedImageView f45175f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f45176g;

    /* renamed from: h  reason: collision with root package name */
    public View f45177h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f45178i;
    public e j;
    public f k;
    public e l;
    public int m;
    public int n;
    public boolean o;
    public int p;
    public int q;
    public Runnable r;

    /* loaded from: classes8.dex */
    public class a implements t.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanAppMenuHeaderView f45179a;

        public a(SwanAppMenuHeaderView swanAppMenuHeaderView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppMenuHeaderView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45179a = swanAppMenuHeaderView;
        }

        @Override // b.a.p0.a.z2.t.b
        public void a(String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, bitmap) == null) || bitmap == null || this.f45179a.f45175f == null) {
                return;
            }
            this.f45179a.f45175f.setImageBitmap(bitmap);
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppMenuHeaderView f45180e;

        public b(SwanAppMenuHeaderView swanAppMenuHeaderView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppMenuHeaderView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45180e = swanAppMenuHeaderView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f45180e.j == null) {
                return;
            }
            this.f45180e.j.onClick(view);
            view.setPressed(true);
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppMenuHeaderView f45181e;

        public c(SwanAppMenuHeaderView swanAppMenuHeaderView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppMenuHeaderView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45181e = swanAppMenuHeaderView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f45181e.l == null) {
                return;
            }
            this.f45181e.l.onClick(view);
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppMenuHeaderView f45182e;

        public d(SwanAppMenuHeaderView swanAppMenuHeaderView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppMenuHeaderView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45182e = swanAppMenuHeaderView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f45182e.k == null) {
                return;
            }
            SwanAppMenuHeaderView swanAppMenuHeaderView = this.f45182e;
            swanAppMenuHeaderView.o = swanAppMenuHeaderView.k.onLongClick(this.f45182e.f45177h);
        }
    }

    /* loaded from: classes8.dex */
    public interface e {
        void onClick(View view);
    }

    /* loaded from: classes8.dex */
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

    public final void g(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            this.f45177h = view.findViewById(b.a.p0.a.f.header_content);
            this.f45175f = (SwanAppRoundedImageView) view.findViewById(b.a.p0.a.f.swan_app_icon);
            this.f45174e = (TextView) view.findViewById(b.a.p0.a.f.swan_app_title);
            this.f45178i = (TextView) view.findViewById(b.a.p0.a.f.btn_item_attenion);
            this.f45176g = (ImageView) view.findViewById(b.a.p0.a.f.apply_guarantee);
            b.a V = b.a.p0.a.d2.d.J().r().V();
            this.f45175f.setImageBitmap(q0.k(V.Q(), "SwanAppMenuHeaderView", false, new a(this)));
            this.f45174e.setText(V.K());
            this.f45174e.setMaxWidth(getResources().getDimensionPixelSize(b.a.p0.a.d.swan_menu_title_max_width_no_icon));
            if (q0.P()) {
                this.f45176g.setVisibility(0);
                this.f45174e.setMaxWidth(getResources().getDimensionPixelSize(b.a.p0.a.d.swan_menu_title_max_width_with_icon));
            }
            this.f45177h.setOnTouchListener(this);
            this.f45177h.setOnClickListener(new b(this));
            this.f45178i.setOnClickListener(new c(this));
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
                if (action == 2 && (Math.abs(this.p - x) > 10.0f || Math.abs(this.q - y) > 10.0f)) {
                    return true;
                }
            } else {
                this.p = (int) x;
                this.q = (int) y;
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
                    removeCallbacks(this.r);
                    if (!this.o && (eVar = this.j) != null) {
                        eVar.onClick(this.f45177h);
                    }
                    this.o = false;
                    view.setPressed(false);
                    return false;
                } else if (action != 2) {
                    if (action == 3) {
                        removeCallbacks(this.r);
                        this.o = false;
                        view.setPressed(false);
                    }
                } else if (Math.abs(this.m - x) > 10 || Math.abs(this.n - y) > 10) {
                    removeCallbacks(this.r);
                    this.o = false;
                }
            } else if (this.k == null) {
                return super.onTouchEvent(motionEvent);
            } else {
                removeCallbacks(this.r);
                this.o = false;
                this.m = x;
                this.n = y;
                postDelayed(this.r, 3000L);
                view.setPressed(true);
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public void setAttentionBtnShow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f45178i.setVisibility(z ? 0 : 8);
        }
    }

    public void setAttentionBtnStates(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            if (b.a.p0.a.c1.a.y0().d()) {
                this.f45178i.setText(h.aiapps_follow_action_text);
                this.f45178i.setBackground(b.a.p0.r.a.b.a.d(getContext(), b.a.p0.a.e.swanapp_teen_mode_attention_btn_bg_selector));
                this.f45178i.setTextColor(b.a.p0.r.a.b.a.b(getContext(), b.a.p0.a.c.swanapp_teen_mode_attention_btn_text_color));
            } else if (!z) {
                this.f45178i.setText(h.aiapps_follow_action_text);
                this.f45178i.setTypeface(Typeface.create("sans-serif-medium", 1));
                this.f45178i.setBackground(b.a.p0.r.a.b.a.d(getContext(), b.a.p0.a.e.swanapp_attention_btn_bg));
                this.f45178i.setTextColor(b.a.p0.r.a.b.a.c(getContext(), b.a.p0.a.c.swanapp_attention_btn_text_color));
            } else {
                this.f45178i.setText(h.swanapp_favored);
                this.f45178i.setTypeface(Typeface.create(TypefaceCompatApi28Impl.DEFAULT_FAMILY, 0));
                this.f45178i.setBackground(b.a.p0.r.a.b.a.d(getContext(), b.a.p0.a.e.swanapp_cancel_attention_btn_bg));
                this.f45178i.setTextColor(b.a.p0.r.a.b.a.c(getContext(), b.a.p0.a.c.swanapp_cancel_attention_btn_text_color));
            }
        }
    }

    public void setOnAttentionBtnClickListener(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, eVar) == null) {
            this.l = eVar;
        }
    }

    public void setOnMenuHeaderClickListener(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, eVar) == null) {
            this.j = eVar;
        }
    }

    public void setOnMenuHeaderLongClickListener(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, fVar) == null) {
            this.k = fVar;
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
    public SwanAppMenuHeaderView(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2) {
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
        this.o = false;
        this.r = new d(this);
        g(FrameLayout.inflate(context, g.swan_app_menu_header_view, this));
        setAttentionBtnStates(b.a.p0.a.j0.b.a.n(b.a.p0.a.d2.d.J().getAppId()));
    }
}

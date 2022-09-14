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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.view.SwanAppRoundedImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.bh4;
import com.baidu.tieba.fm2;
import com.baidu.tieba.sg3;
import com.baidu.tieba.vf3;
import com.baidu.tieba.vn2;
import com.baidu.tieba.w92;
import com.baidu.tieba.x23;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class SwanAppMenuHeaderView extends FrameLayout implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;
    public SwanAppRoundedImageView b;
    public ImageView c;
    public View d;
    public TextView e;
    public e f;
    public f g;
    public e h;
    public int i;
    public int j;
    public boolean k;
    public int l;
    public int m;
    public Runnable n;

    /* loaded from: classes3.dex */
    public class a implements vf3.b {
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

        @Override // com.baidu.tieba.vf3.b
        public void a(String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, bitmap) == null) || bitmap == null || this.a.b == null) {
                return;
            }
            this.a.b.setImageBitmap(bitmap);
        }
    }

    /* loaded from: classes3.dex */
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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.f == null) {
                return;
            }
            this.a.f.onClick(view2);
            view2.setPressed(true);
        }
    }

    /* loaded from: classes3.dex */
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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.h == null) {
                return;
            }
            this.a.h.onClick(view2);
        }
    }

    /* loaded from: classes3.dex */
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
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.g == null) {
                return;
            }
            SwanAppMenuHeaderView swanAppMenuHeaderView = this.a;
            swanAppMenuHeaderView.k = swanAppMenuHeaderView.g.onLongClick(this.a.d);
        }
    }

    /* loaded from: classes3.dex */
    public interface e {
        void onClick(View view2);
    }

    /* loaded from: classes3.dex */
    public interface f {
        boolean onLongClick(View view2);
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

    public final void g(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            this.d = view2.findViewById(R.id.obfuscated_res_0x7f090d49);
            this.b = (SwanAppRoundedImageView) view2.findViewById(R.id.obfuscated_res_0x7f091fc1);
            this.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091fc5);
            this.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09043b);
            this.c = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0902b5);
            vn2.a W = x23.K().q().W();
            this.b.setImageBitmap(sg3.k(W.Q(), "SwanAppMenuHeaderView", false, new a(this)));
            this.a.setText(W.K());
            this.a.setMaxWidth(getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07068c));
            if (sg3.P()) {
                this.c.setVisibility(0);
                this.a.setMaxWidth(getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07068d));
            }
            this.d.setOnTouchListener(this);
            this.d.setOnClickListener(new b(this));
            this.e.setOnClickListener(new c(this));
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
    public boolean onTouch(View view2, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) == null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1) {
                    removeCallbacks(this.n);
                    if (!this.k && (eVar = this.f) != null) {
                        eVar.onClick(this.d);
                    }
                    this.k = false;
                    view2.setPressed(false);
                    return false;
                } else if (action != 2) {
                    if (action == 3) {
                        removeCallbacks(this.n);
                        this.k = false;
                        view2.setPressed(false);
                    }
                } else if (Math.abs(this.i - x) > 10 || Math.abs(this.j - y) > 10) {
                    removeCallbacks(this.n);
                    this.k = false;
                }
            } else if (this.g == null) {
                return super.onTouchEvent(motionEvent);
            } else {
                removeCallbacks(this.n);
                this.k = false;
                this.i = x;
                this.j = y;
                postDelayed(this.n, 3000L);
                view2.setPressed(true);
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public void setAttentionBtnShow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.e.setVisibility(z ? 0 : 8);
        }
    }

    public void setAttentionBtnStates(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            if (fm2.y0().d()) {
                this.e.setText(R.string.obfuscated_res_0x7f0f0161);
                this.e.setBackground(bh4.d(getContext(), R.drawable.obfuscated_res_0x7f0811bb));
                this.e.setTextColor(bh4.b(getContext(), R.color.obfuscated_res_0x7f060ab5));
            } else if (!z) {
                this.e.setText(R.string.obfuscated_res_0x7f0f0161);
                this.e.setTypeface(Typeface.create("sans-serif-medium", 1));
                this.e.setBackground(bh4.d(getContext(), R.drawable.obfuscated_res_0x7f08118f));
                this.e.setTextColor(bh4.c(getContext(), R.color.obfuscated_res_0x7f060aa4));
            } else {
                this.e.setText(R.string.obfuscated_res_0x7f0f12d9);
                this.e.setTypeface(Typeface.create("sans-serif", 0));
                this.e.setBackground(bh4.d(getContext(), R.drawable.obfuscated_res_0x7f081196));
                this.e.setTextColor(bh4.c(getContext(), R.color.obfuscated_res_0x7f060aa5));
            }
        }
    }

    public void setOnAttentionBtnClickListener(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, eVar) == null) {
            this.h = eVar;
        }
    }

    public void setOnMenuHeaderClickListener(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, eVar) == null) {
            this.f = eVar;
        }
    }

    public void setOnMenuHeaderLongClickListener(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, fVar) == null) {
            this.g = fVar;
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
        g(FrameLayout.inflate(context, R.layout.obfuscated_res_0x7f0d0813, this));
        setAttentionBtnStates(w92.n(x23.K().getAppId()));
    }
}

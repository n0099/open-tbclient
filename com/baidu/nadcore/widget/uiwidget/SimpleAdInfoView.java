package com.baidu.nadcore.widget.uiwidget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.tieba.R;
import com.baidu.tieba.ji0;
import com.baidu.tieba.op0;
import com.baidu.tieba.q61;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class SimpleAdInfoView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;
    public TextView b;
    public TextView c;
    public TextView d;
    public op0 e;
    public c f;
    public View.OnClickListener g;
    public int h;

    /* loaded from: classes2.dex */
    public interface c {
        void a(String str);
    }

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SimpleAdInfoView a;

        public a(SimpleAdInfoView simpleAdInfoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {simpleAdInfoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = simpleAdInfoView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.a.e == null) {
                return;
            }
            int id = view2.getId();
            String str2 = "";
            if (id == R.id.obfuscated_res_0x7f0915c2) {
                op0.b bVar = this.a.e.g;
                if (bVar != null) {
                    str2 = bVar.b;
                    str = ClogBuilder.Area.APP_PRIVACY.type;
                }
                str = "";
            } else {
                if (id == R.id.obfuscated_res_0x7f0915c1) {
                    op0.a aVar = this.a.e.h;
                    if (aVar != null) {
                        str2 = aVar.b;
                        str = ClogBuilder.Area.APP_PERMISSION.type;
                    }
                } else if (id == R.id.obfuscated_res_0x7f0915ee) {
                    Toast.makeText(this.a.getContext(), this.a.e.d, 1).show();
                    return;
                } else if (id == R.id.obfuscated_res_0x7f0915c3) {
                    Toast.makeText(this.a.getContext(), this.a.e.f, 1).show();
                    return;
                }
                str = "";
            }
            ji0.c(str2, this.a.getContext());
            c cVar = this.a.f;
            if (cVar != null) {
                cVar.a(str);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TextView a;
        public final /* synthetic */ ViewTreeObserver b;
        public final /* synthetic */ SimpleAdInfoView c;

        public b(SimpleAdInfoView simpleAdInfoView, TextView textView, ViewTreeObserver viewTreeObserver) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {simpleAdInfoView, textView, viewTreeObserver};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = simpleAdInfoView;
            this.a = textView;
            this.b = viewTreeObserver;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int lineCount;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Layout layout = this.a.getLayout();
                if (layout != null && (lineCount = layout.getLineCount()) > 0 && layout.getEllipsisCount(lineCount - 1) > 0) {
                    this.a.setOnClickListener(this.c.g);
                }
                if (this.b.isAlive()) {
                    this.b.removeOnGlobalLayoutListener(this);
                    return;
                }
                ViewTreeObserver viewTreeObserver = this.a.getViewTreeObserver();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnGlobalLayoutListener(this);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleAdInfoView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = new a(this);
        this.h = R.layout.obfuscated_res_0x7f0d0606;
        a(null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleAdInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.g = new a(this);
        this.h = R.layout.obfuscated_res_0x7f0d0606;
        a(attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleAdInfoView(Context context, AttributeSet attributeSet, int i) {
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
        this.g = new a(this);
        this.h = R.layout.obfuscated_res_0x7f0d0606;
        a(attributeSet);
    }

    private void setLayoutByAttrs(AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, this, attributeSet) != null) || attributeSet == null) {
            return;
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, q61.SimpleAdInfoView);
        this.h = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
    }

    public final void b(TextView textView) {
        ViewTreeObserver viewTreeObserver;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textView) != null) || (viewTreeObserver = textView.getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new b(this, textView, viewTreeObserver));
    }

    public void setAfterListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            this.f = cVar;
        }
    }

    public void a(AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, attributeSet) == null) {
            setLayoutByAttrs(attributeSet);
            if (getLayoutId() == -1) {
                return;
            }
            LayoutInflater.from(getContext()).inflate(getLayoutId(), this);
            this.a = (TextView) findViewById(R.id.obfuscated_res_0x7f0915c3);
            this.b = (TextView) findViewById(R.id.obfuscated_res_0x7f0915ee);
            this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f0915c2);
            this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f0915c1);
            TextView textView = this.c;
            if (textView != null) {
                textView.setOnClickListener(this.g);
            }
            TextView textView2 = this.d;
            if (textView2 != null) {
                textView2.setOnClickListener(this.g);
            }
        }
    }

    public int getLayoutId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.h;
        }
        return invokeV.intValue;
    }

    public void setAdInfo(op0 op0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, op0Var) == null) {
            if (op0Var != null && op0Var.k) {
                this.e = op0Var;
                if (this.a != null) {
                    if (!TextUtils.isEmpty(op0Var.f)) {
                        this.a.setText(op0Var.f);
                        this.a.setVisibility(0);
                        b(this.a);
                    } else {
                        this.a.setVisibility(8);
                    }
                }
                if (this.b != null) {
                    if (!TextUtils.isEmpty(op0Var.d)) {
                        this.b.setText(op0Var.d);
                        this.b.setVisibility(0);
                        b(this.b);
                    } else {
                        this.b.setVisibility(8);
                    }
                }
                if (this.c != null) {
                    op0.b bVar = op0Var.g;
                    if (bVar != null && !TextUtils.isEmpty(bVar.b) && !TextUtils.isEmpty(op0Var.g.a)) {
                        this.c.setText(op0Var.g.a);
                        this.c.setVisibility(0);
                    } else {
                        this.c.setVisibility(8);
                    }
                }
                if (this.d != null) {
                    op0.a aVar = op0Var.h;
                    if (aVar != null && !TextUtils.isEmpty(aVar.b) && !TextUtils.isEmpty(op0Var.h.a)) {
                        this.d.setText(op0Var.h.a);
                        this.d.setVisibility(0);
                        return;
                    }
                    this.d.setVisibility(8);
                    return;
                }
                return;
            }
            this.e = null;
        }
    }
}

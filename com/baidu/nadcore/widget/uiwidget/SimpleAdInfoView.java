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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.a0.s.t;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class SimpleAdInfoView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f27845b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f27846c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f27847d;

    /* renamed from: e  reason: collision with root package name */
    public t f27848e;

    /* renamed from: f  reason: collision with root package name */
    public c f27849f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f27850g;

    /* renamed from: h  reason: collision with root package name */
    public int f27851h;

    /* loaded from: classes4.dex */
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
        public void onClick(View view) {
            String str;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.f27848e == null) {
                return;
            }
            int id = view.getId();
            String str2 = "";
            if (id == R.id.obfuscated_res_0x7f09149f) {
                t.b bVar = this.a.f27848e.f1591g;
                if (bVar != null) {
                    str2 = bVar.f1594b;
                    str = ClogBuilder.Area.APP_PRIVACY.type;
                }
                str = "";
            } else {
                if (id == R.id.obfuscated_res_0x7f09149e) {
                    t.a aVar = this.a.f27848e.f1592h;
                    if (aVar != null) {
                        str2 = aVar.f1593b;
                        str = ClogBuilder.Area.APP_PERMISSION.type;
                    }
                } else if (id == R.id.obfuscated_res_0x7f0914c8) {
                    Toast.makeText(this.a.getContext(), this.a.f27848e.f1588d, 1).show();
                    return;
                } else if (id == R.id.obfuscated_res_0x7f0914a0) {
                    Toast.makeText(this.a.getContext(), this.a.f27848e.f1590f, 1).show();
                    return;
                }
                str = "";
            }
            c.a.a0.g.c.c(str2, this.a.getContext());
            c cVar = this.a.f27849f;
            if (cVar != null) {
                cVar.a(str);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TextView a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ViewTreeObserver f27852b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SimpleAdInfoView f27853c;

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
            this.f27853c = simpleAdInfoView;
            this.a = textView;
            this.f27852b = viewTreeObserver;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int lineCount;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Layout layout = this.a.getLayout();
                if (layout != null && (lineCount = layout.getLineCount()) > 0 && layout.getEllipsisCount(lineCount - 1) > 0) {
                    this.a.setOnClickListener(this.f27853c.f27850g);
                }
                if (this.f27852b.isAlive()) {
                    this.f27852b.removeOnGlobalLayoutListener(this);
                    return;
                }
                ViewTreeObserver viewTreeObserver = this.a.getViewTreeObserver();
                if (viewTreeObserver == null || !viewTreeObserver.isAlive()) {
                    return;
                }
                viewTreeObserver.removeOnGlobalLayoutListener(this);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(String str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleAdInfoView(@NonNull Context context) {
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
        this.f27850g = new a(this);
        this.f27851h = R.layout.obfuscated_res_0x7f0d05c1;
        a(null);
    }

    private void setLayoutByAttrs(AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, this, attributeSet) == null) || attributeSet == null) {
            return;
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f040383});
        this.f27851h = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
    }

    public void a(AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, attributeSet) == null) {
            setLayoutByAttrs(attributeSet);
            if (getLayoutId() == -1) {
                return;
            }
            LayoutInflater.from(getContext()).inflate(getLayoutId(), this);
            this.a = (TextView) findViewById(R.id.obfuscated_res_0x7f0914a0);
            this.f27845b = (TextView) findViewById(R.id.obfuscated_res_0x7f0914c8);
            this.f27846c = (TextView) findViewById(R.id.obfuscated_res_0x7f09149f);
            this.f27847d = (TextView) findViewById(R.id.obfuscated_res_0x7f09149e);
            TextView textView = this.f27846c;
            if (textView != null) {
                textView.setOnClickListener(this.f27850g);
            }
            TextView textView2 = this.f27847d;
            if (textView2 != null) {
                textView2.setOnClickListener(this.f27850g);
            }
        }
    }

    public final void b(@NonNull TextView textView) {
        ViewTreeObserver viewTreeObserver;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textView) == null) || (viewTreeObserver = textView.getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new b(this, textView, viewTreeObserver));
    }

    public int getLayoutId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f27851h : invokeV.intValue;
    }

    public void setAdInfo(t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, tVar) == null) {
            if (tVar != null && tVar.k) {
                this.f27848e = tVar;
                if (this.a != null) {
                    if (!TextUtils.isEmpty(tVar.f1590f)) {
                        this.a.setText(tVar.f1590f);
                        this.a.setVisibility(0);
                        b(this.a);
                    } else {
                        this.a.setVisibility(8);
                    }
                }
                if (this.f27845b != null) {
                    if (!TextUtils.isEmpty(tVar.f1588d)) {
                        this.f27845b.setText(tVar.f1588d);
                        this.f27845b.setVisibility(0);
                        b(this.f27845b);
                    } else {
                        this.f27845b.setVisibility(8);
                    }
                }
                if (this.f27846c != null) {
                    t.b bVar = tVar.f1591g;
                    if (bVar != null && !TextUtils.isEmpty(bVar.f1594b) && !TextUtils.isEmpty(tVar.f1591g.a)) {
                        this.f27846c.setText(tVar.f1591g.a);
                        this.f27846c.setVisibility(0);
                    } else {
                        this.f27846c.setVisibility(8);
                    }
                }
                if (this.f27847d != null) {
                    t.a aVar = tVar.f1592h;
                    if (aVar != null && !TextUtils.isEmpty(aVar.f1593b) && !TextUtils.isEmpty(tVar.f1592h.a)) {
                        this.f27847d.setText(tVar.f1592h.a);
                        this.f27847d.setVisibility(0);
                        return;
                    }
                    this.f27847d.setVisibility(8);
                    return;
                }
                return;
            }
            this.f27848e = null;
        }
    }

    public void setAfterListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            this.f27849f = cVar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleAdInfoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
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
        this.f27850g = new a(this);
        this.f27851h = R.layout.obfuscated_res_0x7f0d05c1;
        a(attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleAdInfoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
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
        this.f27850g = new a(this);
        this.f27851h = R.layout.obfuscated_res_0x7f0d05c1;
        a(attributeSet);
    }
}

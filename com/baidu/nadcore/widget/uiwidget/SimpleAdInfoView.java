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
import c.a.c0.f.d;
import c.a.c0.k0.m;
import c.a.c0.k0.n;
import c.a.c0.k0.q;
import c.a.c0.s.p;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class SimpleAdInfoView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f37421e;
    public p mAdInfoModel;
    public c mAfterClickListener;
    public TextView mAuthorNameView;
    public View.OnClickListener mClickListener;
    public TextView mPermissionTagView;
    public TextView mPrivacyTagView;
    public TextView mVersionView;

    /* loaded from: classes10.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SimpleAdInfoView f37422e;

        public a(SimpleAdInfoView simpleAdInfoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {simpleAdInfoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37422e = simpleAdInfoView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f37422e.mAdInfoModel == null) {
                return;
            }
            int id = view.getId();
            String str2 = "";
            if (id == m.nad_app_privacy) {
                p.b bVar = this.f37422e.mAdInfoModel.f2271g;
                if (bVar != null) {
                    str2 = bVar.f2276b;
                    str = ClogBuilder.Area.APP_PRIVACY.type;
                }
                str = "";
            } else {
                if (id == m.nad_app_permission) {
                    p.a aVar = this.f37422e.mAdInfoModel.f2272h;
                    if (aVar != null) {
                        str2 = aVar.f2275b;
                        str = ClogBuilder.Area.APP_PERMISSION.type;
                    }
                } else if (id == m.nad_full_author_name) {
                    Toast.makeText(this.f37422e.getContext(), this.f37422e.mAdInfoModel.f2268d, 1).show();
                    return;
                } else if (id == m.nad_app_version) {
                    Toast.makeText(this.f37422e.getContext(), this.f37422e.mAdInfoModel.f2270f, 1).show();
                    return;
                }
                str = "";
            }
            d.c(str2, this.f37422e.getContext());
            c cVar = this.f37422e.mAfterClickListener;
            if (cVar != null) {
                cVar.a(str);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TextView f37423e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ViewTreeObserver f37424f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ SimpleAdInfoView f37425g;

        public b(SimpleAdInfoView simpleAdInfoView, TextView textView, ViewTreeObserver viewTreeObserver) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {simpleAdInfoView, textView, viewTreeObserver};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37425g = simpleAdInfoView;
            this.f37423e = textView;
            this.f37424f = viewTreeObserver;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int lineCount;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Layout layout = this.f37423e.getLayout();
                if (layout != null && (lineCount = layout.getLineCount()) > 0 && layout.getEllipsisCount(lineCount - 1) > 0) {
                    this.f37423e.setOnClickListener(this.f37425g.mClickListener);
                }
                if (this.f37424f.isAlive()) {
                    this.f37424f.removeOnGlobalLayoutListener(this);
                    return;
                }
                ViewTreeObserver viewTreeObserver = this.f37423e.getViewTreeObserver();
                if (viewTreeObserver == null || !viewTreeObserver.isAlive()) {
                    return;
                }
                viewTreeObserver.removeOnGlobalLayoutListener(this);
            }
        }
    }

    /* loaded from: classes10.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mClickListener = new a(this);
        this.f37421e = n.nad_operate_app_info_layout;
        init(null);
    }

    private void setLayoutByAttrs(AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, this, attributeSet) == null) || attributeSet == null) {
            return;
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, q.SimpleAdInfoView);
        this.f37421e = obtainStyledAttributes.getResourceId(q.SimpleAdInfoView_layoutId, -1);
        obtainStyledAttributes.recycle();
    }

    public final void a(@NonNull TextView textView) {
        ViewTreeObserver viewTreeObserver;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, textView) == null) || (viewTreeObserver = textView.getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new b(this, textView, viewTreeObserver));
    }

    public int getLayoutId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f37421e : invokeV.intValue;
    }

    public void init(AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, attributeSet) == null) {
            setLayoutByAttrs(attributeSet);
            if (getLayoutId() == -1) {
                return;
            }
            LayoutInflater.from(getContext()).inflate(getLayoutId(), this);
            this.mVersionView = (TextView) findViewById(m.nad_app_version);
            this.mAuthorNameView = (TextView) findViewById(m.nad_full_author_name);
            this.mPrivacyTagView = (TextView) findViewById(m.nad_app_privacy);
            this.mPermissionTagView = (TextView) findViewById(m.nad_app_permission);
            TextView textView = this.mPrivacyTagView;
            if (textView != null) {
                textView.setOnClickListener(this.mClickListener);
            }
            TextView textView2 = this.mPermissionTagView;
            if (textView2 != null) {
                textView2.setOnClickListener(this.mClickListener);
            }
        }
    }

    public void setAdInfo(p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, pVar) == null) {
            if (pVar != null && pVar.k) {
                this.mAdInfoModel = pVar;
                if (this.mVersionView != null) {
                    if (!TextUtils.isEmpty(pVar.f2270f)) {
                        this.mVersionView.setText(pVar.f2270f);
                        this.mVersionView.setVisibility(0);
                        a(this.mVersionView);
                    } else {
                        this.mVersionView.setVisibility(8);
                    }
                }
                if (this.mAuthorNameView != null) {
                    if (!TextUtils.isEmpty(pVar.f2268d)) {
                        this.mAuthorNameView.setText(pVar.f2268d);
                        this.mAuthorNameView.setVisibility(0);
                        a(this.mAuthorNameView);
                    } else {
                        this.mAuthorNameView.setVisibility(8);
                    }
                }
                if (this.mPrivacyTagView != null) {
                    p.b bVar = pVar.f2271g;
                    if (bVar != null && !TextUtils.isEmpty(bVar.f2276b) && !TextUtils.isEmpty(pVar.f2271g.a)) {
                        this.mPrivacyTagView.setText(pVar.f2271g.a);
                        this.mPrivacyTagView.setVisibility(0);
                    } else {
                        this.mPrivacyTagView.setVisibility(8);
                    }
                }
                if (this.mPermissionTagView != null) {
                    p.a aVar = pVar.f2272h;
                    if (aVar != null && !TextUtils.isEmpty(aVar.f2275b) && !TextUtils.isEmpty(pVar.f2272h.a)) {
                        this.mPermissionTagView.setText(pVar.f2272h.a);
                        this.mPermissionTagView.setVisibility(0);
                        return;
                    }
                    this.mPermissionTagView.setVisibility(8);
                    return;
                }
                return;
            }
            this.mAdInfoModel = null;
        }
    }

    public void setAfterListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            this.mAfterClickListener = cVar;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mClickListener = new a(this);
        this.f37421e = n.nad_operate_app_info_layout;
        init(attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleAdInfoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.mClickListener = new a(this);
        this.f37421e = n.nad_operate_app_info_layout;
        init(attributeSet);
    }
}

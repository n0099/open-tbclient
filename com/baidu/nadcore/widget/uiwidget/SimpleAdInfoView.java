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
import c.a.b0.s.t;
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

    /* renamed from: e  reason: collision with root package name */
    public int f36056e;
    public t mAdInfoModel;
    public c mAfterClickListener;
    public TextView mAuthorNameView;
    public View.OnClickListener mClickListener;
    public TextView mPermissionTagView;
    public TextView mPrivacyTagView;
    public TextView mVersionView;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SimpleAdInfoView f36057e;

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
            this.f36057e = simpleAdInfoView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f36057e.mAdInfoModel == null) {
                return;
            }
            int id = view.getId();
            String str2 = "";
            if (id == R.id.nad_app_privacy) {
                t.b bVar = this.f36057e.mAdInfoModel.f1972g;
                if (bVar != null) {
                    str2 = bVar.f1977b;
                    str = ClogBuilder.Area.APP_PRIVACY.type;
                }
                str = "";
            } else {
                if (id == R.id.nad_app_permission) {
                    t.a aVar = this.f36057e.mAdInfoModel.f1973h;
                    if (aVar != null) {
                        str2 = aVar.f1976b;
                        str = ClogBuilder.Area.APP_PERMISSION.type;
                    }
                } else if (id == R.id.nad_full_author_name) {
                    Toast.makeText(this.f36057e.getContext(), this.f36057e.mAdInfoModel.f1969d, 1).show();
                    return;
                } else if (id == R.id.nad_app_version) {
                    Toast.makeText(this.f36057e.getContext(), this.f36057e.mAdInfoModel.f1971f, 1).show();
                    return;
                }
                str = "";
            }
            c.a.b0.f.c.c(str2, this.f36057e.getContext());
            c cVar = this.f36057e.mAfterClickListener;
            if (cVar != null) {
                cVar.a(str);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TextView f36058e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ViewTreeObserver f36059f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ SimpleAdInfoView f36060g;

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
            this.f36060g = simpleAdInfoView;
            this.f36058e = textView;
            this.f36059f = viewTreeObserver;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int lineCount;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Layout layout = this.f36058e.getLayout();
                if (layout != null && (lineCount = layout.getLineCount()) > 0 && layout.getEllipsisCount(lineCount - 1) > 0) {
                    this.f36058e.setOnClickListener(this.f36060g.mClickListener);
                }
                if (this.f36059f.isAlive()) {
                    this.f36059f.removeOnGlobalLayoutListener(this);
                    return;
                }
                ViewTreeObserver viewTreeObserver = this.f36058e.getViewTreeObserver();
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
        this.f36056e = R.layout.nad_operate_app_info_layout;
        init(null);
    }

    private void setLayoutByAttrs(AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, this, attributeSet) == null) || attributeSet == null) {
            return;
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, new int[]{R.attr.layoutId});
        this.f36056e = obtainStyledAttributes.getResourceId(0, -1);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f36056e : invokeV.intValue;
    }

    public void init(AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, attributeSet) == null) {
            setLayoutByAttrs(attributeSet);
            if (getLayoutId() == -1) {
                return;
            }
            LayoutInflater.from(getContext()).inflate(getLayoutId(), this);
            this.mVersionView = (TextView) findViewById(R.id.nad_app_version);
            this.mAuthorNameView = (TextView) findViewById(R.id.nad_full_author_name);
            this.mPrivacyTagView = (TextView) findViewById(R.id.nad_app_privacy);
            this.mPermissionTagView = (TextView) findViewById(R.id.nad_app_permission);
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

    public void setAdInfo(t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, tVar) == null) {
            if (tVar != null && tVar.k) {
                this.mAdInfoModel = tVar;
                if (this.mVersionView != null) {
                    if (!TextUtils.isEmpty(tVar.f1971f)) {
                        this.mVersionView.setText(tVar.f1971f);
                        this.mVersionView.setVisibility(0);
                        a(this.mVersionView);
                    } else {
                        this.mVersionView.setVisibility(8);
                    }
                }
                if (this.mAuthorNameView != null) {
                    if (!TextUtils.isEmpty(tVar.f1969d)) {
                        this.mAuthorNameView.setText(tVar.f1969d);
                        this.mAuthorNameView.setVisibility(0);
                        a(this.mAuthorNameView);
                    } else {
                        this.mAuthorNameView.setVisibility(8);
                    }
                }
                if (this.mPrivacyTagView != null) {
                    t.b bVar = tVar.f1972g;
                    if (bVar != null && !TextUtils.isEmpty(bVar.f1977b) && !TextUtils.isEmpty(tVar.f1972g.a)) {
                        this.mPrivacyTagView.setText(tVar.f1972g.a);
                        this.mPrivacyTagView.setVisibility(0);
                    } else {
                        this.mPrivacyTagView.setVisibility(8);
                    }
                }
                if (this.mPermissionTagView != null) {
                    t.a aVar = tVar.f1973h;
                    if (aVar != null && !TextUtils.isEmpty(aVar.f1976b) && !TextUtils.isEmpty(tVar.f1973h.a)) {
                        this.mPermissionTagView.setText(tVar.f1973h.a);
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
        this.f36056e = R.layout.nad_operate_app_info_layout;
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
        this.f36056e = R.layout.nad_operate_app_info_layout;
        init(attributeSet);
    }
}

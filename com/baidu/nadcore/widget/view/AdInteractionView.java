package com.baidu.nadcore.widget.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.c0.b.d;
import c.a.c0.b.e;
import c.a.c0.b.g;
import c.a.c0.b.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class AdInteractionView extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f38640e;

    /* renamed from: f  reason: collision with root package name */
    public AdImageView f38641f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f38642g;

    /* renamed from: h  reason: collision with root package name */
    public FrameLayout f38643h;

    /* renamed from: i  reason: collision with root package name */
    public AdImageView f38644i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f38645j;

    /* renamed from: k  reason: collision with root package name */
    public LinearLayout f38646k;
    public AdImageView l;
    public TextView m;
    public LinearLayout n;
    public LinearLayout o;
    public b p;

    /* loaded from: classes10.dex */
    public interface a {
    }

    /* loaded from: classes10.dex */
    public interface b {
        void onClick(int i2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdInteractionView(Context context) {
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

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            this.f38640e = context;
            LayoutInflater.from(getContext()).inflate(g.nad_interaction_view, this);
            setBackgroundColor(this.f38640e.getResources().getColor(c.a.c0.b.b.nad_videoplayer_transparent));
            setOrientation(1);
            setGravity(17);
            this.f38641f = (AdImageView) findViewById(e.ad_author_avatar_interaction);
            this.f38642g = (TextView) findViewById(e.ad_author_avatar_txt_interaction);
            this.f38643h = (FrameLayout) findViewById(e.ad_author_container_interaction);
            this.f38644i = (AdImageView) findViewById(e.interaction_praise_view);
            this.f38645j = (TextView) findViewById(e.interaction_praise_text);
            this.f38646k = (LinearLayout) findViewById(e.interaction_praise_item);
            this.l = (AdImageView) findViewById(e.interaction_comment_view);
            this.m = (TextView) findViewById(e.interaction_comment_text);
            this.n = (LinearLayout) findViewById(e.interaction_comment_item);
            this.o = (LinearLayout) findViewById(e.interaction_share_item);
            AdImageView adImageView = (AdImageView) findViewById(e.interaction_share_view);
            this.f38643h.setOnClickListener(this);
            this.n.setOnClickListener(this);
            this.o.setOnClickListener(this);
        }
    }

    @Nullable
    public View getView(String str) {
        InterceptResult invokeL;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            int hashCode = str.hashCode();
            if (hashCode == -403497614) {
                if (str.equals("avatarIcon")) {
                    c2 = 0;
                }
                c2 = 65535;
            } else if (hashCode != -403167706) {
                if (hashCode == 705288511 && str.equals("praiseImage")) {
                    c2 = 2;
                }
                c2 = 65535;
            } else {
                if (str.equals("avatarText")) {
                    c2 = 1;
                }
                c2 = 65535;
            }
            if (c2 != 0) {
                if (c2 != 1) {
                    if (c2 != 2) {
                        return null;
                    }
                    return this.f38644i;
                }
                return this.f38642g;
            }
            return this.f38641f;
        }
        return (View) invokeL.objValue;
    }

    public void initAvatar(@Nullable AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, adBaseModel) == null) {
            if (adBaseModel == null) {
                this.f38643h.setVisibility(8);
            } else if (!(getTag() instanceof AdBaseModel)) {
                this.f38643h.setVisibility(8);
            } else if (!((c.a.c0.p.e) getTag()).f2219e) {
                this.f38643h.setVisibility(8);
            } else {
                this.f38643h.setVisibility(0);
                if (!TextUtils.isEmpty(adBaseModel.f38219d.f2229d)) {
                    this.f38642g.setVisibility(8);
                    this.f38641f.displayImage(adBaseModel.f38219d.f2229d);
                } else if (!TextUtils.isEmpty(adBaseModel.f38219d.f2228c)) {
                    this.f38641f.setVisibility(8);
                    this.f38642g.setText(adBaseModel.f38219d.f2228c.substring(0, 1));
                    this.f38642g.setVisibility(0);
                } else {
                    this.f38641f.setVisibility(8);
                    this.f38642g.setVisibility(8);
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            int id = view.getId();
            if (id == e.ad_author_container_interaction) {
                i2 = 0;
            } else if (id == e.interaction_comment_item) {
                i2 = -1;
            } else if (id != e.interaction_share_item) {
                return;
            } else {
                i2 = 3;
            }
            b bVar = this.p;
            if (bVar != null) {
                bVar.onClick(i2);
            }
            if (i2 != 0 && (getTag() instanceof AdBaseModel)) {
                AdBaseModel adBaseModel = (AdBaseModel) getTag();
            }
        }
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    public void setClickPraiseListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
        }
    }

    public void setCommentData(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            TextView textView = this.m;
            if (TextUtils.isEmpty(str) || TextUtils.equals(str, "0")) {
                str = this.f38640e.getResources().getString(h.nad_comment_text);
            }
            textView.setText(str);
            if (getTag() instanceof c.a.c0.p.e) {
                c.a.c0.p.e eVar = (c.a.c0.p.e) getTag();
                if (!eVar.f2216b) {
                    eVar.f2216b = true;
                    this.n.setVisibility(0);
                }
                if (eVar.f2218d) {
                    return;
                }
                eVar.f2218d = true;
                this.l.setImageResource(d.nad_comment_icon);
                this.m.setTextColor(this.f38640e.getResources().getColor(c.a.c0.b.b.ad_praise_text_color));
                this.n.setEnabled(true);
            }
        }
    }

    public void setContainer(@NonNull ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, viewGroup) == null) {
            View view = (View) getParent();
            if (view instanceof ViewGroup) {
                ((ViewGroup) view).removeAllViews();
            }
            viewGroup.removeAllViews();
            viewGroup.addView(this);
        }
    }

    public void setInteractionClickListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.p = bVar;
        }
    }

    public void setInteractionConfig(@NonNull c.a.c0.p.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, eVar) == null) {
            setTag(eVar);
            if (eVar.a) {
                this.f38646k.setVisibility(0);
            } else {
                this.f38646k.setVisibility(8);
            }
            if (eVar.f2216b) {
                this.n.setVisibility(0);
            } else {
                this.n.setVisibility(8);
            }
            if (eVar.f2217c) {
                this.o.setVisibility(0);
            } else {
                this.o.setVisibility(8);
            }
            if (eVar.f2218d) {
                this.l.setImageResource(d.nad_comment_icon);
                this.m.setTextColor(this.f38640e.getResources().getColor(c.a.c0.b.b.ad_praise_text_color));
                this.n.setEnabled(true);
            } else {
                this.l.setImageResource(d.nad_comment_disabled_icon);
                this.m.setTextColor(this.f38640e.getResources().getColor(c.a.c0.b.b.nad_comment_disabled_text_color));
                this.m.setText(this.f38640e.getResources().getString(h.nad_comment_text));
                this.n.setEnabled(eVar.f2216b);
            }
            if (eVar.f2219e) {
                this.f38643h.setVisibility(0);
            } else {
                this.f38643h.setVisibility(8);
            }
        }
    }

    public void setPraiseData(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048586, this, z, str) == null) {
            TextView textView = this.f38645j;
            if (TextUtils.isEmpty(str)) {
                str = this.f38640e.getResources().getString(h.nad_praise_text);
            }
            textView.setText(str);
        }
    }

    public void updatePraisedTextColor() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdInteractionView(Context context, @Nullable AttributeSet attributeSet) {
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
    public AdInteractionView(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        a(context);
    }
}

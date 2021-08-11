package a.a.a.a.s.b.a;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import b.a.a.a.t.b.a.a;
import b.a.a.a.x.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.Glide;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.fun.ad.sdk.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TextView f1014a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f1015b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f1016c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f1017d;

    /* renamed from: e  reason: collision with root package name */
    public Button f1018e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context) {
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
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context, @Nullable AttributeSet attributeSet) {
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
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
    }

    public void a(Activity activity, TTNativeAd tTNativeAd, TTNativeAd.AdInteractionListener adInteractionListener) {
        Button button;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, activity, tTNativeAd, adInteractionListener) == null) {
            this.f1014a.setText(tTNativeAd.getDescription());
            TTImage icon = tTNativeAd.getIcon();
            if (icon != null && icon.isValid()) {
                Context context = getContext();
                String imageUrl = icon.getImageUrl();
                ImageView imageView = this.f1015b;
                if (context == null) {
                    d.f("GlideHelper: context is null when load: " + imageUrl, new Object[0]);
                } else if (context instanceof Activity) {
                    Activity activity2 = (Activity) context;
                    if (activity2.isFinishing() || (Build.VERSION.SDK_INT > 17 && activity2.isDestroyed())) {
                        d.f("GlideHelper: activity is destroyed when load: " + imageUrl, new Object[0]);
                    } else {
                        Glide.with(activity2).load(imageUrl).into(imageView);
                    }
                } else {
                    Glide.with(context).load(imageUrl).into(imageView);
                }
            }
            this.f1016c.setText(TextUtils.isEmpty(tTNativeAd.getSource()) ? tTNativeAd.getTitle() : tTNativeAd.getSource());
            this.f1017d.setImageBitmap(tTNativeAd.getAdLogo());
            int interactionType = tTNativeAd.getInteractionType();
            if (interactionType == 2 || interactionType == 3) {
                this.f1018e.setVisibility(0);
                button = this.f1018e;
                i2 = R.string.ad_interaction_type_browser;
            } else if (interactionType == 4) {
                tTNativeAd.setActivityForDownloadApp(activity);
                this.f1018e.setVisibility(0);
                button = this.f1018e;
                i2 = R.string.ad_interaction_type_download;
            } else if (interactionType != 5) {
                this.f1018e.setVisibility(8);
                ArrayList arrayList = new ArrayList();
                arrayList.add(this);
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(this.f1018e);
                tTNativeAd.registerViewForInteraction(this, arrayList, arrayList2, adInteractionListener);
                tTNativeAd.setDownloadListener(new a(this.f1018e));
            } else {
                this.f1018e.setVisibility(0);
                button = this.f1018e;
                i2 = R.string.ad_interaction_type_dial;
            }
            button.setText(i2);
            ArrayList arrayList3 = new ArrayList();
            arrayList3.add(this);
            ArrayList arrayList22 = new ArrayList();
            arrayList22.add(this.f1018e);
            tTNativeAd.registerViewForInteraction(this, arrayList3, arrayList22, adInteractionListener);
            tTNativeAd.setDownloadListener(new a(this.f1018e));
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onFinishInflate();
            this.f1014a = (TextView) findViewById(R.id.ad_description);
            this.f1017d = (ImageView) findViewById(R.id.ad_logo);
            this.f1015b = (ImageView) findViewById(R.id.ad_icon);
            this.f1016c = (TextView) findViewById(R.id.ad_source);
            this.f1018e = (Button) findViewById(R.id.ad_creative);
        }
    }
}

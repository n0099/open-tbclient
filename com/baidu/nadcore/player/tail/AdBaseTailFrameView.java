package com.baidu.nadcore.player.tail;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d0.d.h;
import c.a.d0.s.r;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.view.AdProgressButton;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.nadcore.styles.Font;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.nadcore.widget.txt.UnifyTextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public abstract class AdBaseTailFrameView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean DEBUG = false;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public d f37303e;

    /* renamed from: f  reason: collision with root package name */
    public e f37304f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f37305g;

    /* renamed from: h  reason: collision with root package name */
    public c f37306h;
    public AdImageView mAvatarView;
    public TextView mCheckBtn;
    public AdImageView mCoverImageView;
    public AdProgressButton mDownloadBtn;
    public c.a.d0.j.f.d mDownloadPresenter;
    public TextView mNameView;
    public FrameLayout mOperateRootView;
    public TextView mTimerCloseTxt;

    /* loaded from: classes10.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdBaseTailFrameView f37307e;

        public a(AdBaseTailFrameView adBaseTailFrameView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adBaseTailFrameView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37307e = adBaseTailFrameView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f37307e.mDownloadPresenter.o();
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f37308e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ r f37309f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ AdBaseTailFrameView f37310g;

        public b(AdBaseTailFrameView adBaseTailFrameView, boolean z, r rVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adBaseTailFrameView, Boolean.valueOf(z), rVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37310g = adBaseTailFrameView;
            this.f37308e = z;
            this.f37309f = rVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                Object tag = this.f37310g.getTag();
                if (tag instanceof r) {
                    r rVar = (r) tag;
                    if (!this.f37308e) {
                        this.f37310g.c(this.f37309f, view);
                    } else if (!rVar.p) {
                        this.f37310g.c(this.f37309f, view);
                    } else {
                        this.f37310g.mDownloadBtn.performClick();
                    }
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public interface c {
        void a();
    }

    /* loaded from: classes10.dex */
    public interface d {
        void a(String str, String str2);
    }

    /* loaded from: classes10.dex */
    public interface e {
        void a();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdBaseTailFrameView(Context context) {
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

    public final void b(r rVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, rVar) == null) || rVar == null) {
            return;
        }
        e eVar = this.f37304f;
        if (eVar == null) {
            c.a.d0.a0.b.a.b(rVar.k);
        } else {
            eVar.a();
        }
    }

    public final void c(r rVar, View view) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rVar, view) == null) || TextUtils.isEmpty(rVar.f3110c)) {
            return;
        }
        String str2 = rVar.f3110c;
        if (c.a.d0.d.e.ad_video_tail_frame_check_btn_txt == view.getId() && !TextUtils.isEmpty(rVar.f3111d) && !"__BTN_SCHEME__".equals(rVar.f3111d)) {
            str2 = rVar.f3111d;
        }
        c.a.d0.f.d.c(str2, getContext());
        int id = view.getId();
        if (id == c.a.d0.d.e.ad_video_tail_frame_avatar) {
            str = ClogBuilder.Area.ICON.type;
        } else if (id == c.a.d0.d.e.ad_video_tail_frame_name) {
            str = ClogBuilder.Area.NAME.type;
        } else if (id == c.a.d0.d.e.ad_video_tail_frame_check_btn_txt) {
            str = ClogBuilder.Area.BUTTON.type;
        } else {
            str = ClogBuilder.Area.HOTAREA.type;
        }
        e(ClogBuilder.LogType.CLICK.type, str, rVar);
        b(rVar);
        f(view);
        c cVar = this.f37306h;
        if (cVar != null) {
            cVar.a();
        }
    }

    public final void d(r rVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, rVar) == null) || rVar == null) {
            return;
        }
        d dVar = this.f37303e;
        if (dVar == null) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.s(ClogBuilder.LogType.FREE_SHOW).q(ClogBuilder.Page.AD_TAIL).n(rVar.l);
            c.a.d0.a0.a.b(clogBuilder);
            return;
        }
        dVar.a(ClogBuilder.LogType.FREE_SHOW.type, "");
    }

    public final void e(String str, String str2, r rVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, rVar) == null) || rVar == null) {
            return;
        }
        d dVar = this.f37303e;
        if (dVar == null) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.t(str).q(ClogBuilder.Page.AD_TAIL).h(str2).n(rVar.l);
            c.a.d0.a0.a.b(clogBuilder);
            return;
        }
        dVar.a(str, str2);
    }

    public final void f(View view) {
        View.OnClickListener onClickListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, view) == null) || (onClickListener = this.f37305g) == null) {
            return;
        }
        onClickListener.onClick(view);
    }

    public void hideTailFrame() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            setVisibility(8);
        }
    }

    public void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            LayoutInflater.from(context).inflate(layoutId(), this);
            this.mCoverImageView = (AdImageView) findViewById(c.a.d0.d.e.ad_video_tail_frame_video_cover);
            this.mAvatarView = (AdImageView) findViewById(c.a.d0.d.e.ad_video_tail_frame_avatar);
            this.mNameView = (TextView) findViewById(c.a.d0.d.e.ad_video_tail_frame_name);
            TextView textView = (TextView) findViewById(c.a.d0.d.e.ad_video_tail_frame_check_btn_txt);
            this.mCheckBtn = textView;
            c.a.d0.b0.a.b(textView, Font.F_F_X02);
            this.mDownloadBtn = (AdProgressButton) findViewById(c.a.d0.d.e.ad_video_tail_frame_download_btn_txt);
            this.mOperateRootView = (FrameLayout) findViewById(c.a.d0.d.e.ad_video_tail_frame_btn_container);
            this.mTimerCloseTxt = (TextView) findViewById(c.a.d0.d.e.video_ad_suffix_close_divider);
            onNightModeChanged();
        }
    }

    public abstract int layoutId();

    public void onNightModeChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    public void setAdTailCloseListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) {
            this.f37306h = cVar;
        }
    }

    public void setAlsHandler(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, dVar) == null) {
            this.f37303e = dVar;
        }
    }

    public void setOnChargeHandler(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, eVar) == null) {
            this.f37304f = eVar;
        }
    }

    public void setOnJumpHandler(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, onClickListener) == null) {
            this.f37305g = onClickListener;
        }
    }

    public boolean showTailFrame(r rVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, rVar)) == null) {
            if (rVar != null && rVar.i()) {
                setVisibility(0);
                if (!TextUtils.isEmpty(rVar.f3117j)) {
                    this.mCoverImageView.setImageURI(Uri.parse(rVar.f3117j));
                }
                if (!TextUtils.isEmpty(rVar.f3109b)) {
                    this.mAvatarView.setVisibility(0);
                    this.mAvatarView.displayImage(rVar.f3109b);
                } else {
                    this.mAvatarView.setVisibility(8);
                }
                if (!TextUtils.isEmpty(rVar.a)) {
                    this.mNameView.setVisibility(0);
                    ((UnifyTextView) this.mNameView).setTextWithUnifiedPadding(rVar.a, TextView.BufferType.NORMAL);
                } else {
                    this.mNameView.setVisibility(8);
                }
                boolean h2 = rVar.h();
                if (h2) {
                    this.mCheckBtn.setVisibility(8);
                    c.a.d0.s.c cVar = rVar.m;
                    if (cVar != null && cVar.f3078e) {
                        this.mDownloadBtn.setVisibility(0);
                        if (!TextUtils.isEmpty(rVar.f3112e)) {
                            this.mDownloadBtn.setText(rVar.f3112e);
                        } else {
                            this.mDownloadBtn.setText(getResources().getString(h.nad_button_download));
                        }
                        c.a.d0.j.d.a c2 = c.a.d0.j.d.a.c(rVar.m, rVar.l, rVar.f3111d);
                        c2.f2800e = TextUtils.isEmpty(c2.f2799d);
                        this.mDownloadPresenter = new c.a.d0.j.f.d(c2, this.mDownloadBtn);
                        this.mDownloadBtn.setOnClickListener(new a(this));
                    } else {
                        this.mDownloadBtn.setVisibility(8);
                        this.mDownloadPresenter = null;
                    }
                } else {
                    if (this.mDownloadPresenter != null) {
                        this.mDownloadPresenter = null;
                    }
                    this.mDownloadBtn.setVisibility(8);
                    this.mCheckBtn.setVisibility(0);
                    if (!TextUtils.isEmpty(rVar.f3112e)) {
                        this.mCheckBtn.setText(rVar.f3112e);
                    } else {
                        this.mCheckBtn.setText(getResources().getText(h.nad_ad_video_check_btn_txt));
                    }
                }
                b bVar = new b(this, h2, rVar);
                this.mAvatarView.setOnClickListener(bVar);
                this.mNameView.setOnClickListener(bVar);
                this.mCheckBtn.setOnClickListener(bVar);
                if (rVar.o) {
                    setOnClickListener(bVar);
                } else {
                    setOnClickListener(null);
                }
                d(rVar);
                setTag(rVar);
                return true;
            }
            setVisibility(8);
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdBaseTailFrameView(Context context, AttributeSet attributeSet) {
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
    public AdBaseTailFrameView(Context context, AttributeSet attributeSet, int i2) {
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
        init(context);
    }
}

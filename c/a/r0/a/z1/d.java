package c.a.r0.a.z1;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.p.d.k0;
import c.a.r0.a.z1.j.b;
import c.a.r0.a.z1.j.e;
import c.a.r0.a.z2.m0;
import c.a.r0.a.z2.n0;
import c.a.r0.a.z2.u;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrackConfig;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.publisher.ReplyEditorParams;
import com.baidu.swan.apps.publisher.emoji.EmojiEditText;
import com.baidu.swan.apps.publisher.view.SPSwitchPanelLinearLayout;
import com.baidu.swan.apps.res.ui.BdBaseImageView;
import com.baidu.swan.apps.res.widget.dialog.SwanAppAlertDialog;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d extends c.a.r0.r.a.a.i implements View.OnClickListener, c.a.r0.a.j1.d.d.c<MediaModel> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrameLayout A0;
    public SimpleDraweeView B0;
    public BdBaseImageView C0;
    public ImageView D0;
    public SPSwitchPanelLinearLayout E0;
    public View F0;
    public boolean G0;
    public ImageView H0;
    public boolean I0;
    public boolean J0;
    public ReplyEditorParams K0;
    public boolean L0;
    public c.a.r0.a.z1.a M0;
    public String N0;
    public MediaModel O0;
    public LinearLayout u0;
    public Context v0;
    public EmojiEditText w0;
    public LinearLayout x0;
    public TextView y0;
    public TextView z0;

    /* loaded from: classes.dex */
    public class a implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f9861e;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9861e = dVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                this.f9861e.h1();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements View.OnKeyListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f9862e;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9862e = dVar;
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i2, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, view, i2, keyEvent)) == null) {
                if (keyEvent.getAction() == 0 && i2 == 4) {
                    this.f9862e.z1();
                    return true;
                }
                return false;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public class c implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f9863e;

        public c(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9863e = dVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                this.f9863e.z1();
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* renamed from: c.a.r0.a.z1.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0648d implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f9864e;

        public C0648d(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9864e = dVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                this.f9864e.I1(editable);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements EmojiEditText.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public e(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // com.baidu.swan.apps.publisher.emoji.EmojiEditText.e
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            }
        }

        @Override // com.baidu.swan.apps.publisher.emoji.EmojiEditText.e
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            }
        }

        @Override // com.baidu.swan.apps.publisher.emoji.EmojiEditText.e
        public void onBack() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.z1();
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements EmojiEditText.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public f(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // com.baidu.swan.apps.publisher.emoji.EmojiEditText.e
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            }
        }

        @Override // com.baidu.swan.apps.publisher.emoji.EmojiEditText.e
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            }
        }

        @Override // com.baidu.swan.apps.publisher.emoji.EmojiEditText.e
        public void onBack() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.z1();
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements e.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f9865e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f9866f;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ g f9867e;

            public a(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f9867e = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f9867e.f9866f.u0.setVisibility(0);
                }
            }
        }

        public g(d dVar, ViewGroup viewGroup) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, viewGroup};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9866f = dVar;
            this.f9865e = viewGroup;
        }

        @Override // c.a.r0.a.z1.j.e.b
        public void onSoftInputShowing(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f9866f.J0 = z;
                if (z) {
                    this.f9866f.H0.setImageResource(c.a.r0.a.e.swanapp_reply_editor_emotion);
                    this.f9865e.post(new a(this));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class h implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public h(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // c.a.r0.a.z1.j.b.c
        public void onClickSwitch(View view, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view, z) == null) {
                this.a.I0 = z;
                if (z) {
                    this.a.H0.setImageResource(c.a.r0.a.e.swanapp_reply_editor_keyboard);
                } else {
                    this.a.H0.setImageResource(c.a.r0.a.e.swanapp_reply_editor_emotion);
                }
                c.a.r0.a.z1.j.d.onEvent("emoji_clk");
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f9868e;

        public i(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9868e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f9868e.u0.setVisibility(0);
            }
        }
    }

    /* loaded from: classes.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f9869e;

        public j(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9869e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ((InputMethodManager) this.f9869e.w0.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.f9869e.w0.getWindowToken(), 0);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(442633238, "Lc/a/r0/a/z1/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(442633238, "Lc/a/r0/a/z1/d;");
        }
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.G0 = false;
        this.I0 = false;
        this.J0 = false;
        this.L0 = false;
    }

    public final StateListDrawable A1(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            float g2 = n0.g(4.0f);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(g2);
            gradientDrawable.setColor(i2);
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setCornerRadius(g2);
            gradientDrawable2.setColor((i2 & 16777215) + 855638016);
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, gradientDrawable2);
            stateListDrawable.addState(new int[]{16842910}, gradientDrawable);
            stateListDrawable.addState(new int[]{-16842910}, gradientDrawable2);
            return stateListDrawable;
        }
        return (StateListDrawable) invokeI.objValue;
    }

    public final void B1(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || this.M0 == null) {
            return;
        }
        if (!SwanAppNetworkUtils.i(getContext())) {
            c.a.r0.a.z1.j.g.h(getContext(), c.a.r0.a.h.swanapp_publisher_network_disconnect);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.K0.supportPicture()) {
                JSONObject jSONObject2 = new JSONObject();
                if (this.O0 != null) {
                    jSONObject2.put("path", c.a.r0.a.g1.f.U().G().h(this.O0.getTempPath()));
                    jSONObject2.put("size", this.O0.getSize());
                }
                jSONObject.put("tempFile", jSONObject2);
            }
            if (this.N0 == null) {
                this.N0 = "";
            }
            jSONObject.put("content", this.N0);
            jSONObject.put("status", str);
            this.M0.a(jSONObject);
            this.G0 = true;
            if (TextUtils.equals("reply", str)) {
                D1();
                c.a.r0.a.z1.e.c().a();
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public final boolean C1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            FrameLayout frameLayout = this.A0;
            return frameLayout != null && frameLayout.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    public final void D1() {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (frameLayout = this.A0) == null) {
            return;
        }
        this.O0 = null;
        frameLayout.setVisibility(8);
        u1(false);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void E1() {
        Window window;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (window = j1().getWindow()) == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) window.getDecorView().findViewById(16908290);
        c.a.r0.a.z1.j.e.c(getActivity(), viewGroup, this.E0, new g(this, viewGroup));
        c.a.r0.a.z1.j.b.b(this.E0, this.H0, this.w0, new h(this));
        c.a.r0.a.z1.h.d.b().c(getActivity(), this.E0, this.w0, this.K0.emojiPath, c.a.r0.a.d2.e.f0(), c.a.r0.a.d2.e.L().j0());
        this.u0.setVisibility(4);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void F1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            v1();
            this.A0 = new FrameLayout(this.v0);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(n0.g(60.0f), n0.g(60.0f));
            layoutParams.topMargin = n0.g(8.0f);
            layoutParams.bottomMargin = n0.g(8.0f);
            layoutParams.leftMargin = n0.g(19.0f);
            layoutParams.rightMargin = n0.g(9.0f);
            this.x0.addView(this.A0, layoutParams);
            FrameLayout frameLayout = new FrameLayout(this.v0);
            frameLayout.setBackgroundResource(c.a.r0.a.e.swanapp_reply_editor_picture_bg);
            frameLayout.setPadding(1, 1, 1, 1);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1, 17);
            SimpleDraweeView simpleDraweeView = new SimpleDraweeView(this.v0);
            this.B0 = simpleDraweeView;
            simpleDraweeView.setScaleType(ImageView.ScaleType.CENTER);
            frameLayout.addView(this.B0, layoutParams2);
            this.A0.addView(frameLayout, layoutParams2);
            RoundingParams roundingParams = new RoundingParams();
            roundingParams.setBorderColor(268435456);
            roundingParams.setBorderWidth(1.0f);
            roundingParams.setCornersRadius(n0.g(3.0f));
            roundingParams.setOverlayColor(-1);
            GenericDraweeHierarchy build = new GenericDraweeHierarchyBuilder(this.v0.getResources()).build();
            build.setRoundingParams(roundingParams);
            this.B0.setHierarchy(build);
            this.C0 = new BdBaseImageView(this.v0);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(n0.g(20.0f), n0.g(20.0f));
            layoutParams3.gravity = 8388613;
            this.A0.addView(this.C0, layoutParams3);
            this.C0.setImageResource(c.a.r0.a.e.swanapp_reply_editor_picture_close);
            this.B0.setOnClickListener(this);
            this.C0.setOnTouchListener(new m0());
            this.C0.setOnClickListener(this);
        }
    }

    public final void G1(@NonNull View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view) == null) {
            this.x0 = (LinearLayout) view.findViewById(c.a.r0.a.f.input_layout);
            this.w0 = (EmojiEditText) view.findViewById(c.a.r0.a.f.content);
            this.y0 = (TextView) view.findViewById(c.a.r0.a.f.length_hint);
            this.z0 = (TextView) view.findViewById(c.a.r0.a.f.send_button);
            this.D0 = (ImageView) view.findViewById(c.a.r0.a.f.input_picture_button);
            this.H0 = (ImageView) view.findViewById(c.a.r0.a.f.emotion_button);
            this.E0 = (SPSwitchPanelLinearLayout) view.findViewById(c.a.r0.a.f.panel_root);
            this.F0 = view.findViewById(c.a.r0.a.f.place_holder);
        }
    }

    public final void H1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            j1().setCanceledOnTouchOutside(true);
            Window window = j1().getWindow();
            if (window != null) {
                window.setBackgroundDrawable(new ColorDrawable(0));
                window.getDecorView().setPadding(0, 0, 0, 0);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.gravity = 80;
                attributes.width = -1;
                attributes.height = -1;
                attributes.softInputMode = 16;
                attributes.dimAmount = 0.0f;
                window.setAttributes(attributes);
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void I0(View view, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view, bundle) == null) {
            super.I0(view, bundle);
            if (this.L0) {
                K1();
                return;
            }
            H1();
            y1();
            E1();
            x1();
            c.a.r0.a.z1.j.d.onEvent("show");
        }
    }

    public final void I1(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, charSequence) == null) {
            this.N0 = charSequence.toString();
            int a2 = c.a.r0.a.z1.j.f.a(charSequence.toString());
            if (a2 < 0) {
                return;
            }
            if (a2 == 0) {
                if (C1()) {
                    this.z0.setEnabled(true);
                    this.y0.setVisibility(8);
                    return;
                }
                this.z0.setEnabled(false);
                this.y0.setVisibility(8);
            } else if (a2 <= 200) {
                this.z0.setEnabled(true);
                if (a2 < 180) {
                    this.y0.setVisibility(8);
                    return;
                }
                this.y0.setVisibility(0);
                this.y0.setText(String.format(this.v0.getResources().getString(c.a.r0.a.h.swanapp_reply_editor_text_remain), Integer.valueOf(200 - a2)));
                this.y0.setTextColor(ContextCompat.getColor(this.v0, c.a.r0.a.c.swanapp_reply_editor_input_length_hint_color));
            } else {
                this.z0.setEnabled(false);
                this.y0.setVisibility(0);
                this.y0.setTextColor(ContextCompat.getColor(this.v0, c.a.r0.a.c.swanapp_reply_editor_over_length_color));
                if (a2 < 1200) {
                    this.y0.setText(String.format(this.v0.getResources().getString(c.a.r0.a.h.swanapp_reply_editor_text_overstep), Integer.valueOf(a2 - 200)));
                } else {
                    this.y0.setText(this.v0.getResources().getString(c.a.r0.a.h.swanapp_reply_editor_text_999_overstep));
                }
            }
        }
    }

    public void J1(c.a.r0.a.z1.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) {
            this.M0 = aVar;
        }
    }

    public final void K1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            SwanAppAlertDialog.a aVar = new SwanAppAlertDialog.a(getContext());
            aVar.m(false);
            aVar.U(c.a.r0.a.h.swanapp_publisher_error_title);
            aVar.v(c.a.r0.a.h.swanapp_publisher_params_error);
            aVar.O(c.a.r0.a.h.aiapps_confirm, new a(this));
            aVar.X();
        }
    }

    public final void L1(MediaModel mediaModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, mediaModel) == null) {
            String tempPath = mediaModel.getTempPath();
            if (TextUtils.isEmpty(tempPath)) {
                FrameLayout frameLayout = this.A0;
                if (frameLayout != null) {
                    frameLayout.setVisibility(8);
                    return;
                }
                return;
            }
            FrameLayout frameLayout2 = this.A0;
            if (frameLayout2 != null) {
                frameLayout2.setVisibility(0);
            }
            this.B0.setController(Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(true).setOldController(this.B0.getController()).setImageRequest(ImageRequestBuilder.newBuilderWithSource(u.m(tempPath)).setResizeOptions(new ResizeOptions(n0.o(this.v0), n0.n(this.v0))).build()).build());
            String str = this.N0;
            if (str == null) {
                str = "";
            }
            I1(str);
        }
    }

    @Override // c.a.r0.a.j1.d.d.c
    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
        }
    }

    @Override // c.a.r0.r.a.a.i
    public void h1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            LinearLayout linearLayout = this.u0;
            if (linearLayout != null) {
                linearLayout.setOnKeyListener(null);
            }
            super.h1();
        }
    }

    @Override // c.a.r0.a.j1.d.d.c
    public void j(List<MediaModel> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, list) == null) || list == null || list.size() == 0) {
            return;
        }
        MediaModel mediaModel = list.get(0);
        this.O0 = mediaModel;
        L1(mediaModel);
    }

    @Override // c.a.r0.r.a.a.i
    public Dialog l1(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, bundle)) == null) {
            Dialog l1 = super.l1(bundle);
            l1.getWindow().requestFeature(1);
            return l1;
        }
        return (Dialog) invokeL.objValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        k0 C;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, view) == null) {
            if (view == this.z0) {
                B1("reply");
                c.a.r0.a.z1.j.d.onEvent("pub_clk");
            } else if (view == this.C0) {
                D1();
                I1(this.w0.getText());
                c.a.r0.a.z1.j.d.onEvent("pic_clk_del");
            } else if (view == this.D0) {
                c.a.r0.a.z1.j.g.j(1, true, this);
                c.a.r0.a.z1.j.d.onEvent("pic_clk_bar");
            } else if (view != this.B0 || (C = c.a.r0.a.c1.a.C()) == null) {
            } else {
                C.d(getContext(), new String[]{this.O0.getPath()}, 0);
            }
        }
    }

    @Override // c.a.r0.r.a.a.i, com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bundle) == null) {
            super.onCreate(bundle);
            this.v0 = getActivity();
            Bundle t = t();
            if (t != null) {
                this.K0 = (ReplyEditorParams) t.getParcelable("params");
                if (t.getBoolean(MediaTrackConfig.AE_IMPORT_DRAFT)) {
                    this.N0 = t.getString("content");
                    this.O0 = (MediaModel) t.getParcelable("image");
                }
                if (this.K0 == null) {
                    this.L0 = true;
                    return;
                }
                return;
            }
            this.L0 = true;
        }
    }

    @Override // c.a.r0.r.a.a.i, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, dialogInterface) == null) {
            EmojiEditText emojiEditText = this.w0;
            Editable text = emojiEditText != null ? emojiEditText.getText() : null;
            if (this.G0 || text == null || TextUtils.isEmpty(text.toString())) {
                if (this.G0 || this.w0 == null || !C1()) {
                    EmojiEditText emojiEditText2 = this.w0;
                    if (emojiEditText2 != null) {
                        emojiEditText2.postDelayed(new j(this), 400L);
                    }
                    super.onDismiss(dialogInterface);
                }
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onResume();
            if (!this.I0 || this.J0) {
                c.a.r0.a.z1.j.e.n(this.w0, 160L);
                LinearLayout linearLayout = this.u0;
                if (linearLayout != null) {
                    linearLayout.postDelayed(new i(this), 280L);
                }
            }
        }
    }

    public final void u1(boolean z) {
        EmojiEditText emojiEditText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048597, this, z) == null) || (emojiEditText = this.w0) == null) {
            return;
        }
        if (z) {
            emojiEditText.setPadding(n0.g(8.0f), this.w0.getPaddingTop(), 0, this.w0.getPaddingBottom());
        } else {
            emojiEditText.setPadding(n0.g(8.0f), this.w0.getPaddingTop(), n0.g(8.0f), this.w0.getPaddingBottom());
        }
    }

    public final void v1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            int childCount = this.x0.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.x0.getChildAt(i2);
                if (!(childAt instanceof EmojiEditText)) {
                    this.x0.removeView(childAt);
                }
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    @SuppressLint({"ClickableViewAccessibility"})
    public View w0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048599, this, layoutInflater, viewGroup, bundle)) == null) {
            LinearLayout linearLayout = (LinearLayout) layoutInflater.inflate(c.a.r0.a.g.swanapp_reply_editor_layout, viewGroup, false);
            this.u0 = linearLayout;
            G1(linearLayout);
            this.u0.setFocusableInTouchMode(true);
            this.u0.setOnKeyListener(new b(this));
            this.z0.setOnClickListener(this);
            if (this.K0.supportPicture()) {
                this.D0.setVisibility(0);
                this.D0.setOnClickListener(this);
                this.D0.setOnTouchListener(new m0());
            } else {
                this.D0.setVisibility(8);
            }
            if (this.K0.supportEmoji()) {
                this.H0.setVisibility(0);
                this.H0.setOnTouchListener(new m0());
            } else {
                this.H0.setVisibility(8);
            }
            this.F0.setOnTouchListener(new c(this));
            this.w0.addTextChangedListener(new C0648d(this));
            this.w0.setListener(new e(this));
            this.w0.setListener(new f(this));
            F1();
            if (this.O0 == null) {
                D1();
            }
            this.w0.requestFocus();
            return this.u0;
        }
        return (View) invokeLLL.objValue;
    }

    public void w1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.w0.setText("");
            z1();
        }
    }

    public final void x1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            if (this.N0 != null) {
                SpannableString g2 = c.a.r0.a.z1.h.b.c().g(this.v0, this.N0, this.w0);
                this.w0.setText(g2);
                this.w0.setSelection(g2.length());
                I1(g2);
            }
            if (this.O0 != null) {
                u1(true);
                L1(this.O0);
                return;
            }
            u1(false);
        }
    }

    public final void y1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.w0.setHint(this.K0.contentHint);
            this.z0.setText(this.K0.sendText);
            this.z0.setTextColor(this.K0.sendTextColor);
            this.z0.setBackground(A1(this.K0.sendTextBgColor));
            if (this.K0.supportNoModule()) {
                this.u0.findViewById(c.a.r0.a.f.module_layout).setVisibility(8);
            }
        }
    }

    public void z1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            if (TextUtils.isEmpty(this.N0) && this.O0 == null) {
                c.a.r0.a.z1.e.c().a();
            } else {
                c.a.r0.a.z1.e.c().d(this.N0, this.O0);
            }
            B1(MediaTrackConfig.AE_IMPORT_DRAFT);
            h1();
        }
    }
}

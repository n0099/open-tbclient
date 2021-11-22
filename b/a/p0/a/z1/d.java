package b.a.p0.a.z1;

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
import b.a.p0.a.p.d.k0;
import b.a.p0.a.z1.j.b;
import b.a.p0.a.z1.j.e;
import b.a.p0.a.z2.m0;
import b.a.p0.a.z2.n0;
import b.a.p0.a.z2.u;
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
public class d extends b.a.p0.r.a.a.i implements View.OnClickListener, b.a.p0.a.j1.d.d.c<MediaModel> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SimpleDraweeView A0;
    public BdBaseImageView B0;
    public ImageView C0;
    public SPSwitchPanelLinearLayout D0;
    public View E0;
    public boolean F0;
    public ImageView G0;
    public boolean H0;
    public boolean I0;
    public ReplyEditorParams J0;
    public boolean K0;
    public b.a.p0.a.z1.a L0;
    public String M0;
    public MediaModel N0;
    public LinearLayout t0;
    public Context u0;
    public EmojiEditText v0;
    public LinearLayout w0;
    public TextView x0;
    public TextView y0;
    public FrameLayout z0;

    /* loaded from: classes.dex */
    public class a implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f9637e;

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
            this.f9637e = dVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                this.f9637e.k1();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements View.OnKeyListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f9638e;

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
            this.f9638e = dVar;
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i2, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, view, i2, keyEvent)) == null) {
                if (keyEvent.getAction() == 0 && i2 == 4) {
                    this.f9638e.C1();
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
        public final /* synthetic */ d f9639e;

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
            this.f9639e = dVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                this.f9639e.C1();
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* renamed from: b.a.p0.a.z1.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0499d implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f9640e;

        public C0499d(d dVar) {
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
            this.f9640e = dVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                this.f9640e.L1(editable);
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

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f9641a;

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
            this.f9641a = dVar;
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
                this.f9641a.C1();
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements EmojiEditText.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f9642a;

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
            this.f9642a = dVar;
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
                this.f9642a.C1();
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements e.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f9643e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f9644f;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ g f9645e;

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
                this.f9645e = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f9645e.f9644f.t0.setVisibility(0);
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
            this.f9644f = dVar;
            this.f9643e = viewGroup;
        }

        @Override // b.a.p0.a.z1.j.e.b
        public void onSoftInputShowing(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f9644f.I0 = z;
                if (z) {
                    this.f9644f.G0.setImageResource(b.a.p0.a.e.swanapp_reply_editor_emotion);
                    this.f9643e.post(new a(this));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class h implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f9646a;

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
            this.f9646a = dVar;
        }

        @Override // b.a.p0.a.z1.j.b.c
        public void onClickSwitch(View view, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view, z) == null) {
                this.f9646a.H0 = z;
                if (z) {
                    this.f9646a.G0.setImageResource(b.a.p0.a.e.swanapp_reply_editor_keyboard);
                } else {
                    this.f9646a.G0.setImageResource(b.a.p0.a.e.swanapp_reply_editor_emotion);
                }
                b.a.p0.a.z1.j.d.onEvent("emoji_clk");
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f9647e;

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
            this.f9647e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f9647e.t0.setVisibility(0);
            }
        }
    }

    /* loaded from: classes.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f9648e;

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
            this.f9648e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ((InputMethodManager) this.f9648e.v0.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.f9648e.v0.getWindowToken(), 0);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1341218873, "Lb/a/p0/a/z1/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1341218873, "Lb/a/p0/a/z1/d;");
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
        this.F0 = false;
        this.H0 = false;
        this.I0 = false;
        this.K0 = false;
    }

    public final void A1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.M0 != null) {
                SpannableString g2 = b.a.p0.a.z1.h.b.c().g(this.u0, this.M0, this.v0);
                this.v0.setText(g2);
                this.v0.setSelection(g2.length());
                L1(g2);
            }
            if (this.N0 != null) {
                x1(true);
                O1(this.N0);
                return;
            }
            x1(false);
        }
    }

    public final void B1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.v0.setHint(this.J0.contentHint);
            this.y0.setText(this.J0.sendText);
            this.y0.setTextColor(this.J0.sendTextColor);
            this.y0.setBackground(D1(this.J0.sendTextBgColor));
            if (this.J0.supportNoModule()) {
                this.t0.findViewById(b.a.p0.a.f.module_layout).setVisibility(8);
            }
        }
    }

    public void C1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (TextUtils.isEmpty(this.M0) && this.N0 == null) {
                b.a.p0.a.z1.e.c().a();
            } else {
                b.a.p0.a.z1.e.c().d(this.M0, this.N0);
            }
            E1(MediaTrackConfig.AE_IMPORT_DRAFT);
            k1();
        }
    }

    public final StateListDrawable D1(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
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

    public final void E1(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || this.L0 == null) {
            return;
        }
        if (!SwanAppNetworkUtils.i(getContext())) {
            b.a.p0.a.z1.j.g.h(getContext(), b.a.p0.a.h.swanapp_publisher_network_disconnect);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.J0.supportPicture()) {
                JSONObject jSONObject2 = new JSONObject();
                if (this.N0 != null) {
                    jSONObject2.put("path", b.a.p0.a.g1.f.U().G().h(this.N0.getTempPath()));
                    jSONObject2.put("size", this.N0.getSize());
                }
                jSONObject.put("tempFile", jSONObject2);
            }
            if (this.M0 == null) {
                this.M0 = "";
            }
            jSONObject.put("content", this.M0);
            jSONObject.put("status", str);
            this.L0.a(jSONObject);
            this.F0 = true;
            if (TextUtils.equals("reply", str)) {
                G1();
                b.a.p0.a.z1.e.c().a();
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public final boolean F1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            FrameLayout frameLayout = this.z0;
            return frameLayout != null && frameLayout.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    public final void G1() {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (frameLayout = this.z0) == null) {
            return;
        }
        this.N0 = null;
        frameLayout.setVisibility(8);
        x1(false);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void H1() {
        Window window;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (window = m1().getWindow()) == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) window.getDecorView().findViewById(16908290);
        b.a.p0.a.z1.j.e.c(getActivity(), viewGroup, this.D0, new g(this, viewGroup));
        b.a.p0.a.z1.j.b.b(this.D0, this.G0, this.v0, new h(this));
        b.a.p0.a.z1.h.d.b().c(getActivity(), this.D0, this.v0, this.J0.emojiPath, b.a.p0.a.d2.e.f0(), b.a.p0.a.d2.e.L().j0());
        this.t0.setVisibility(4);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void I1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            y1();
            this.z0 = new FrameLayout(this.u0);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(n0.g(60.0f), n0.g(60.0f));
            layoutParams.topMargin = n0.g(8.0f);
            layoutParams.bottomMargin = n0.g(8.0f);
            layoutParams.leftMargin = n0.g(19.0f);
            layoutParams.rightMargin = n0.g(9.0f);
            this.w0.addView(this.z0, layoutParams);
            FrameLayout frameLayout = new FrameLayout(this.u0);
            frameLayout.setBackgroundResource(b.a.p0.a.e.swanapp_reply_editor_picture_bg);
            frameLayout.setPadding(1, 1, 1, 1);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1, 17);
            SimpleDraweeView simpleDraweeView = new SimpleDraweeView(this.u0);
            this.A0 = simpleDraweeView;
            simpleDraweeView.setScaleType(ImageView.ScaleType.CENTER);
            frameLayout.addView(this.A0, layoutParams2);
            this.z0.addView(frameLayout, layoutParams2);
            RoundingParams roundingParams = new RoundingParams();
            roundingParams.setBorderColor(268435456);
            roundingParams.setBorderWidth(1.0f);
            roundingParams.setCornersRadius(n0.g(3.0f));
            roundingParams.setOverlayColor(-1);
            GenericDraweeHierarchy build = new GenericDraweeHierarchyBuilder(this.u0.getResources()).build();
            build.setRoundingParams(roundingParams);
            this.A0.setHierarchy(build);
            this.B0 = new BdBaseImageView(this.u0);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(n0.g(20.0f), n0.g(20.0f));
            layoutParams3.gravity = 8388613;
            this.z0.addView(this.B0, layoutParams3);
            this.B0.setImageResource(b.a.p0.a.e.swanapp_reply_editor_picture_close);
            this.A0.setOnClickListener(this);
            this.B0.setOnTouchListener(new m0());
            this.B0.setOnClickListener(this);
        }
    }

    public final void J1(@NonNull View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view) == null) {
            this.w0 = (LinearLayout) view.findViewById(b.a.p0.a.f.input_layout);
            this.v0 = (EmojiEditText) view.findViewById(b.a.p0.a.f.content);
            this.x0 = (TextView) view.findViewById(b.a.p0.a.f.length_hint);
            this.y0 = (TextView) view.findViewById(b.a.p0.a.f.send_button);
            this.C0 = (ImageView) view.findViewById(b.a.p0.a.f.input_picture_button);
            this.G0 = (ImageView) view.findViewById(b.a.p0.a.f.emotion_button);
            this.D0 = (SPSwitchPanelLinearLayout) view.findViewById(b.a.p0.a.f.panel_root);
            this.E0 = view.findViewById(b.a.p0.a.f.place_holder);
        }
    }

    public final void K1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            m1().setCanceledOnTouchOutside(true);
            Window window = m1().getWindow();
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
    public void L0(View view, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, view, bundle) == null) {
            super.L0(view, bundle);
            if (this.K0) {
                N1();
                return;
            }
            K1();
            B1();
            H1();
            A1();
            b.a.p0.a.z1.j.d.onEvent("show");
        }
    }

    public final void L1(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, charSequence) == null) {
            this.M0 = charSequence.toString();
            int a2 = b.a.p0.a.z1.j.f.a(charSequence.toString());
            if (a2 < 0) {
                return;
            }
            if (a2 == 0) {
                if (F1()) {
                    this.y0.setEnabled(true);
                    this.x0.setVisibility(8);
                    return;
                }
                this.y0.setEnabled(false);
                this.x0.setVisibility(8);
            } else if (a2 <= 200) {
                this.y0.setEnabled(true);
                if (a2 < 180) {
                    this.x0.setVisibility(8);
                    return;
                }
                this.x0.setVisibility(0);
                this.x0.setText(String.format(this.u0.getResources().getString(b.a.p0.a.h.swanapp_reply_editor_text_remain), Integer.valueOf(200 - a2)));
                this.x0.setTextColor(ContextCompat.getColor(this.u0, b.a.p0.a.c.swanapp_reply_editor_input_length_hint_color));
            } else {
                this.y0.setEnabled(false);
                this.x0.setVisibility(0);
                this.x0.setTextColor(ContextCompat.getColor(this.u0, b.a.p0.a.c.swanapp_reply_editor_over_length_color));
                if (a2 < 1200) {
                    this.x0.setText(String.format(this.u0.getResources().getString(b.a.p0.a.h.swanapp_reply_editor_text_overstep), Integer.valueOf(a2 - 200)));
                } else {
                    this.x0.setText(this.u0.getResources().getString(b.a.p0.a.h.swanapp_reply_editor_text_999_overstep));
                }
            }
        }
    }

    public void M1(b.a.p0.a.z1.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) {
            this.L0 = aVar;
        }
    }

    public final void N1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            SwanAppAlertDialog.a aVar = new SwanAppAlertDialog.a(getContext());
            aVar.m(false);
            aVar.U(b.a.p0.a.h.swanapp_publisher_error_title);
            aVar.v(b.a.p0.a.h.swanapp_publisher_params_error);
            aVar.O(b.a.p0.a.h.aiapps_confirm, new a(this));
            aVar.X();
        }
    }

    public final void O1(MediaModel mediaModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, mediaModel) == null) {
            String tempPath = mediaModel.getTempPath();
            if (TextUtils.isEmpty(tempPath)) {
                FrameLayout frameLayout = this.z0;
                if (frameLayout != null) {
                    frameLayout.setVisibility(8);
                    return;
                }
                return;
            }
            FrameLayout frameLayout2 = this.z0;
            if (frameLayout2 != null) {
                frameLayout2.setVisibility(0);
            }
            this.A0.setController(Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(true).setOldController(this.A0.getController()).setImageRequest(ImageRequestBuilder.newBuilderWithSource(u.m(tempPath)).setResizeOptions(new ResizeOptions(n0.o(this.u0), n0.n(this.u0))).build()).build());
            String str = this.M0;
            if (str == null) {
                str = "";
            }
            L1(str);
        }
    }

    @Override // b.a.p0.a.j1.d.d.c
    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
        }
    }

    @Override // b.a.p0.a.j1.d.d.c
    public void f(List<MediaModel> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, list) == null) || list == null || list.size() == 0) {
            return;
        }
        MediaModel mediaModel = list.get(0);
        this.N0 = mediaModel;
        O1(mediaModel);
    }

    @Override // b.a.p0.r.a.a.i
    public void k1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            LinearLayout linearLayout = this.t0;
            if (linearLayout != null) {
                linearLayout.setOnKeyListener(null);
            }
            super.k1();
        }
    }

    @Override // b.a.p0.r.a.a.i
    public Dialog o1(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, bundle)) == null) {
            Dialog o1 = super.o1(bundle);
            o1.getWindow().requestFeature(1);
            return o1;
        }
        return (Dialog) invokeL.objValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        k0 C;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, view) == null) {
            if (view == this.y0) {
                E1("reply");
                b.a.p0.a.z1.j.d.onEvent("pub_clk");
            } else if (view == this.B0) {
                G1();
                L1(this.v0.getText());
                b.a.p0.a.z1.j.d.onEvent("pic_clk_del");
            } else if (view == this.C0) {
                b.a.p0.a.z1.j.g.j(1, true, this);
                b.a.p0.a.z1.j.d.onEvent("pic_clk_bar");
            } else if (view != this.A0 || (C = b.a.p0.a.c1.a.C()) == null) {
            } else {
                C.d(getContext(), new String[]{this.N0.getPath()}, 0);
            }
        }
    }

    @Override // b.a.p0.r.a.a.i, com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, bundle) == null) {
            super.onCreate(bundle);
            this.u0 = getActivity();
            Bundle o = o();
            if (o != null) {
                this.J0 = (ReplyEditorParams) o.getParcelable("params");
                if (o.getBoolean(MediaTrackConfig.AE_IMPORT_DRAFT)) {
                    this.M0 = o.getString("content");
                    this.N0 = (MediaModel) o.getParcelable("image");
                }
                if (this.J0 == null) {
                    this.K0 = true;
                    return;
                }
                return;
            }
            this.K0 = true;
        }
    }

    @Override // b.a.p0.r.a.a.i, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, dialogInterface) == null) {
            EmojiEditText emojiEditText = this.v0;
            Editable text = emojiEditText != null ? emojiEditText.getText() : null;
            if (this.F0 || text == null || TextUtils.isEmpty(text.toString())) {
                if (this.F0 || this.v0 == null || !F1()) {
                    EmojiEditText emojiEditText2 = this.v0;
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
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.onResume();
            if (!this.H0 || this.I0) {
                b.a.p0.a.z1.j.e.n(this.v0, 160L);
                LinearLayout linearLayout = this.t0;
                if (linearLayout != null) {
                    linearLayout.postDelayed(new i(this), 280L);
                }
            }
        }
    }

    public final void x1(boolean z) {
        EmojiEditText emojiEditText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048600, this, z) == null) || (emojiEditText = this.v0) == null) {
            return;
        }
        if (z) {
            emojiEditText.setPadding(n0.g(8.0f), this.v0.getPaddingTop(), 0, this.v0.getPaddingBottom());
        } else {
            emojiEditText.setPadding(n0.g(8.0f), this.v0.getPaddingTop(), n0.g(8.0f), this.v0.getPaddingBottom());
        }
    }

    public final void y1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            int childCount = this.w0.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.w0.getChildAt(i2);
                if (!(childAt instanceof EmojiEditText)) {
                    this.w0.removeView(childAt);
                }
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    @SuppressLint({"ClickableViewAccessibility"})
    public View z0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048602, this, layoutInflater, viewGroup, bundle)) == null) {
            LinearLayout linearLayout = (LinearLayout) layoutInflater.inflate(b.a.p0.a.g.swanapp_reply_editor_layout, viewGroup, false);
            this.t0 = linearLayout;
            J1(linearLayout);
            this.t0.setFocusableInTouchMode(true);
            this.t0.setOnKeyListener(new b(this));
            this.y0.setOnClickListener(this);
            if (this.J0.supportPicture()) {
                this.C0.setVisibility(0);
                this.C0.setOnClickListener(this);
                this.C0.setOnTouchListener(new m0());
            } else {
                this.C0.setVisibility(8);
            }
            if (this.J0.supportEmoji()) {
                this.G0.setVisibility(0);
                this.G0.setOnTouchListener(new m0());
            } else {
                this.G0.setVisibility(8);
            }
            this.E0.setOnTouchListener(new c(this));
            this.v0.addTextChangedListener(new C0499d(this));
            this.v0.setListener(new e(this));
            this.v0.setListener(new f(this));
            I1();
            if (this.N0 == null) {
                G1();
            }
            this.v0.requestFocus();
            return this.t0;
        }
        return (View) invokeLLL.objValue;
    }

    public void z1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.v0.setText("");
            C1();
        }
    }
}

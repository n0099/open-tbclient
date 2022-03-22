package c.a.n0.a.p1;

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
import c.a.n0.a.f.d.k0;
import c.a.n0.a.p1.j.b;
import c.a.n0.a.p1.j.e;
import c.a.n0.a.p2.m0;
import c.a.n0.a.p2.n0;
import c.a.n0.a.p2.u;
import c.a.n0.a.s1.b.b.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrackConfig;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.publisher.ReplyEditorParams;
import com.baidu.swan.apps.publisher.emoji.EmojiEditText;
import com.baidu.swan.apps.publisher.view.SPSwitchPanelLinearLayout;
import com.baidu.swan.apps.res.ui.BdBaseImageView;
import com.baidu.tieba.R;
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
public class d extends c.a.n0.r.a.a.i implements View.OnClickListener, c.a.n0.a.z0.d.d.c<MediaModel> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SPSwitchPanelLinearLayout A0;
    public View B0;
    public boolean C0;
    public ImageView D0;
    public boolean E0;
    public boolean F0;
    public ReplyEditorParams G0;
    public boolean H0;
    public c.a.n0.a.p1.a I0;
    public String J0;
    public MediaModel K0;
    public LinearLayout q0;
    public Context r0;
    public EmojiEditText s0;
    public LinearLayout t0;
    public TextView u0;
    public TextView v0;
    public FrameLayout w0;
    public SimpleDraweeView x0;
    public BdBaseImageView y0;
    public ImageView z0;

    /* loaded from: classes.dex */
    public class a implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                this.a.l1();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements View.OnKeyListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, view, i, keyEvent)) == null) {
                if (keyEvent.getAction() == 0 && i == 4) {
                    this.a.D1();
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
        public final /* synthetic */ d a;

        public c(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                this.a.D1();
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* renamed from: c.a.n0.a.p1.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0413d implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public C0413d(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                this.a.M1(editable);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // com.baidu.swan.apps.publisher.emoji.EmojiEditText.e
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        @Override // com.baidu.swan.apps.publisher.emoji.EmojiEditText.e
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            }
        }

        @Override // com.baidu.swan.apps.publisher.emoji.EmojiEditText.e
        public void onBack() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.D1();
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // com.baidu.swan.apps.publisher.emoji.EmojiEditText.e
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        @Override // com.baidu.swan.apps.publisher.emoji.EmojiEditText.e
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            }
        }

        @Override // com.baidu.swan.apps.publisher.emoji.EmojiEditText.e
        public void onBack() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.D1();
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements e.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f5735b;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g a;

            public a(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.f5735b.q0.setVisibility(0);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5735b = dVar;
            this.a = viewGroup;
        }

        @Override // c.a.n0.a.p1.j.e.b
        public void onSoftInputShowing(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f5735b.F0 = z;
                if (z) {
                    this.f5735b.D0.setImageResource(R.drawable.obfuscated_res_0x7f081174);
                    this.a.post(new a(this));
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // c.a.n0.a.p1.j.b.c
        public void onClickSwitch(View view, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view, z) == null) {
                this.a.E0 = z;
                if (z) {
                    this.a.D0.setImageResource(R.drawable.obfuscated_res_0x7f081176);
                } else {
                    this.a.D0.setImageResource(R.drawable.obfuscated_res_0x7f081174);
                }
                c.a.n0.a.p1.j.d.onEvent("emoji_clk");
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public i(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.q0.setVisibility(0);
            }
        }
    }

    /* loaded from: classes.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public j(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ((InputMethodManager) this.a.s0.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.a.s0.getWindowToken(), 0);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1219452048, "Lc/a/n0/a/p1/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1219452048, "Lc/a/n0/a/p1/d;");
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
        this.C0 = false;
        this.E0 = false;
        this.F0 = false;
        this.H0 = false;
    }

    public void A1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.s0.setText("");
            D1();
        }
    }

    public final void B1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.J0 != null) {
                SpannableString g2 = c.a.n0.a.p1.h.b.c().g(this.r0, this.J0, this.s0);
                this.s0.setText(g2);
                this.s0.setSelection(g2.length());
                M1(g2);
            }
            if (this.K0 != null) {
                y1(true);
                P1(this.K0);
                return;
            }
            y1(false);
        }
    }

    public final void C1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.s0.setHint(this.G0.contentHint);
            this.v0.setText(this.G0.sendText);
            this.v0.setTextColor(this.G0.sendTextColor);
            this.v0.setBackground(E1(this.G0.sendTextBgColor));
            if (this.G0.supportNoModule()) {
                this.q0.findViewById(R.id.obfuscated_res_0x7f09142d).setVisibility(8);
            }
        }
    }

    public void D1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (TextUtils.isEmpty(this.J0) && this.K0 == null) {
                c.a.n0.a.p1.e.c().a();
            } else {
                c.a.n0.a.p1.e.c().d(this.J0, this.K0);
            }
            F1(MediaTrackConfig.AE_IMPORT_DRAFT);
            l1();
        }
    }

    public final StateListDrawable E1(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
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

    public final void F1(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || this.I0 == null) {
            return;
        }
        if (!SwanAppNetworkUtils.i(getContext())) {
            c.a.n0.a.p1.j.g.h(getContext(), R.string.obfuscated_res_0x7f0f12b4);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.G0.supportPicture()) {
                JSONObject jSONObject2 = new JSONObject();
                if (this.K0 != null) {
                    jSONObject2.put("path", c.a.n0.a.w0.f.U().G().h(this.K0.getTempPath()));
                    jSONObject2.put("size", this.K0.getSize());
                }
                jSONObject.put("tempFile", jSONObject2);
            }
            if (this.J0 == null) {
                this.J0 = "";
            }
            jSONObject.put("content", this.J0);
            jSONObject.put("status", str);
            this.I0.a(jSONObject);
            this.C0 = true;
            if (TextUtils.equals("reply", str)) {
                H1();
                c.a.n0.a.p1.e.c().a();
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public final boolean G1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            FrameLayout frameLayout = this.w0;
            return frameLayout != null && frameLayout.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    public final void H1() {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (frameLayout = this.w0) == null) {
            return;
        }
        this.K0 = null;
        frameLayout.setVisibility(8);
        y1(false);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void I1() {
        Window window;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (window = n1().getWindow()) == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) window.getDecorView().findViewById(16908290);
        c.a.n0.a.p1.j.e.c(getActivity(), viewGroup, this.A0, new g(this, viewGroup));
        c.a.n0.a.p1.j.b.b(this.A0, this.D0, this.s0, new h(this));
        c.a.n0.a.p1.h.d.b().c(getActivity(), this.A0, this.s0, this.G0.emojiPath, c.a.n0.a.t1.e.f0(), c.a.n0.a.t1.e.L().j0());
        this.q0.setVisibility(4);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void J1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            z1();
            this.w0 = new FrameLayout(this.r0);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(n0.g(60.0f), n0.g(60.0f));
            layoutParams.topMargin = n0.g(8.0f);
            layoutParams.bottomMargin = n0.g(8.0f);
            layoutParams.leftMargin = n0.g(19.0f);
            layoutParams.rightMargin = n0.g(9.0f);
            this.t0.addView(this.w0, layoutParams);
            FrameLayout frameLayout = new FrameLayout(this.r0);
            frameLayout.setBackgroundResource(R.drawable.obfuscated_res_0x7f081178);
            frameLayout.setPadding(1, 1, 1, 1);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1, 17);
            SimpleDraweeView simpleDraweeView = new SimpleDraweeView(this.r0);
            this.x0 = simpleDraweeView;
            simpleDraweeView.setScaleType(ImageView.ScaleType.CENTER);
            frameLayout.addView(this.x0, layoutParams2);
            this.w0.addView(frameLayout, layoutParams2);
            RoundingParams roundingParams = new RoundingParams();
            roundingParams.setBorderColor(LaunchTaskConstants.OTHER_PROCESS);
            roundingParams.setBorderWidth(1.0f);
            roundingParams.setCornersRadius(n0.g(3.0f));
            roundingParams.setOverlayColor(-1);
            GenericDraweeHierarchy build = new GenericDraweeHierarchyBuilder(this.r0.getResources()).build();
            build.setRoundingParams(roundingParams);
            this.x0.setHierarchy(build);
            this.y0 = new BdBaseImageView(this.r0);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(n0.g(20.0f), n0.g(20.0f));
            layoutParams3.gravity = 8388613;
            this.w0.addView(this.y0, layoutParams3);
            this.y0.setImageResource(R.drawable.obfuscated_res_0x7f081179);
            this.x0.setOnClickListener(this);
            this.y0.setOnTouchListener(new m0());
            this.y0.setOnClickListener(this);
        }
    }

    public final void K1(@NonNull View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, view) == null) {
            this.t0 = (LinearLayout) view.findViewById(R.id.obfuscated_res_0x7f090efd);
            this.s0 = (EmojiEditText) view.findViewById(R.id.obfuscated_res_0x7f0906d7);
            this.u0 = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091230);
            this.v0 = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091c95);
            this.z0 = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f090eff);
            this.D0 = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f09086d);
            this.A0 = (SPSwitchPanelLinearLayout) view.findViewById(R.id.obfuscated_res_0x7f091645);
            this.B0 = view.findViewById(R.id.obfuscated_res_0x7f091850);
        }
    }

    public final void L1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            n1().setCanceledOnTouchOutside(true);
            Window window = n1().getWindow();
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
    public void M0(View view, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, view, bundle) == null) {
            super.M0(view, bundle);
            if (this.H0) {
                O1();
                return;
            }
            L1();
            C1();
            I1();
            B1();
            c.a.n0.a.p1.j.d.onEvent("show");
        }
    }

    public final void M1(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, charSequence) == null) {
            this.J0 = charSequence.toString();
            int a2 = c.a.n0.a.p1.j.f.a(charSequence.toString());
            if (a2 < 0) {
                return;
            }
            if (a2 == 0) {
                if (G1()) {
                    this.v0.setEnabled(true);
                    this.u0.setVisibility(8);
                    return;
                }
                this.v0.setEnabled(false);
                this.u0.setVisibility(8);
            } else if (a2 <= 200) {
                this.v0.setEnabled(true);
                if (a2 < 180) {
                    this.u0.setVisibility(8);
                    return;
                }
                this.u0.setVisibility(0);
                this.u0.setText(String.format(this.r0.getResources().getString(R.string.obfuscated_res_0x7f0f12c1), Integer.valueOf(200 - a2)));
                this.u0.setTextColor(ContextCompat.getColor(this.r0, R.color.obfuscated_res_0x7f060a7c));
            } else {
                this.v0.setEnabled(false);
                this.u0.setVisibility(0);
                this.u0.setTextColor(ContextCompat.getColor(this.r0, R.color.obfuscated_res_0x7f060a7d));
                if (a2 < 1200) {
                    this.u0.setText(String.format(this.r0.getResources().getString(R.string.obfuscated_res_0x7f0f12c0), Integer.valueOf(a2 - 200)));
                } else {
                    this.u0.setText(this.r0.getResources().getString(R.string.obfuscated_res_0x7f0f12bf));
                }
            }
        }
    }

    public void N1(c.a.n0.a.p1.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, aVar) == null) {
            this.I0 = aVar;
        }
    }

    public final void O1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            h.a aVar = new h.a(getContext());
            aVar.m(false);
            aVar.U(R.string.obfuscated_res_0x7f0f12b1);
            aVar.v(R.string.obfuscated_res_0x7f0f12b5);
            aVar.O(R.string.obfuscated_res_0x7f0f010f, new a(this));
            aVar.X();
        }
    }

    public final void P1(MediaModel mediaModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, mediaModel) == null) {
            String tempPath = mediaModel.getTempPath();
            if (TextUtils.isEmpty(tempPath)) {
                FrameLayout frameLayout = this.w0;
                if (frameLayout != null) {
                    frameLayout.setVisibility(8);
                    return;
                }
                return;
            }
            FrameLayout frameLayout2 = this.w0;
            if (frameLayout2 != null) {
                frameLayout2.setVisibility(0);
            }
            this.x0.setController(Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(true).setOldController(this.x0.getController()).setImageRequest(ImageRequestBuilder.newBuilderWithSource(u.m(tempPath)).setResizeOptions(new ResizeOptions(n0.o(this.r0), n0.n(this.r0))).build()).build());
            String str = this.J0;
            if (str == null) {
                str = "";
            }
            M1(str);
        }
    }

    @Override // c.a.n0.a.z0.d.d.c
    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
        }
    }

    @Override // c.a.n0.a.z0.d.d.c
    public void f(List<MediaModel> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, list) == null) || list == null || list.size() == 0) {
            return;
        }
        MediaModel mediaModel = list.get(0);
        this.K0 = mediaModel;
        P1(mediaModel);
    }

    @Override // c.a.n0.r.a.a.i
    public void l1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            LinearLayout linearLayout = this.q0;
            if (linearLayout != null) {
                linearLayout.setOnKeyListener(null);
            }
            super.l1();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        k0 C;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, view) == null) {
            if (view == this.v0) {
                F1("reply");
                c.a.n0.a.p1.j.d.onEvent("pub_clk");
            } else if (view == this.y0) {
                H1();
                M1(this.s0.getText());
                c.a.n0.a.p1.j.d.onEvent("pic_clk_del");
            } else if (view == this.z0) {
                c.a.n0.a.p1.j.g.j(1, true, this);
                c.a.n0.a.p1.j.d.onEvent("pic_clk_bar");
            } else if (view != this.x0 || (C = c.a.n0.a.s0.a.C()) == null) {
            } else {
                C.d(getContext(), new String[]{this.K0.getPath()}, 0);
            }
        }
    }

    @Override // c.a.n0.r.a.a.i, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, dialogInterface) == null) {
            EmojiEditText emojiEditText = this.s0;
            Editable text = emojiEditText != null ? emojiEditText.getText() : null;
            if (this.C0 || text == null || TextUtils.isEmpty(text.toString())) {
                if (this.C0 || this.s0 == null || !G1()) {
                    EmojiEditText emojiEditText2 = this.s0;
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
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onResume();
            if (!this.E0 || this.F0) {
                c.a.n0.a.p1.j.e.n(this.s0, 160L);
                LinearLayout linearLayout = this.q0;
                if (linearLayout != null) {
                    linearLayout.postDelayed(new i(this), 280L);
                }
            }
        }
    }

    @Override // c.a.n0.r.a.a.i
    public Dialog p1(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, bundle)) == null) {
            Dialog p1 = super.p1(bundle);
            p1.getWindow().requestFeature(1);
            return p1;
        }
        return (Dialog) invokeL.objValue;
    }

    @Override // c.a.n0.r.a.a.i, com.baidu.swan.support.v4.app.Fragment
    public void u0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, bundle) == null) {
            super.u0(bundle);
            this.r0 = getActivity();
            Bundle p = p();
            if (p != null) {
                this.G0 = (ReplyEditorParams) p.getParcelable("params");
                if (p.getBoolean(MediaTrackConfig.AE_IMPORT_DRAFT)) {
                    this.J0 = p.getString("content");
                    this.K0 = (MediaModel) p.getParcelable("image");
                }
                if (this.G0 == null) {
                    this.H0 = true;
                    return;
                }
                return;
            }
            this.H0 = true;
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    @SuppressLint({"ClickableViewAccessibility"})
    public View x0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048601, this, layoutInflater, viewGroup, bundle)) == null) {
            LinearLayout linearLayout = (LinearLayout) layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d07e1, viewGroup, false);
            this.q0 = linearLayout;
            K1(linearLayout);
            this.q0.setFocusableInTouchMode(true);
            this.q0.setOnKeyListener(new b(this));
            this.v0.setOnClickListener(this);
            if (this.G0.supportPicture()) {
                this.z0.setVisibility(0);
                this.z0.setOnClickListener(this);
                this.z0.setOnTouchListener(new m0());
            } else {
                this.z0.setVisibility(8);
            }
            if (this.G0.supportEmoji()) {
                this.D0.setVisibility(0);
                this.D0.setOnTouchListener(new m0());
            } else {
                this.D0.setVisibility(8);
            }
            this.B0.setOnTouchListener(new c(this));
            this.s0.addTextChangedListener(new C0413d(this));
            this.s0.setListener(new e(this));
            this.s0.setListener(new f(this));
            J1();
            if (this.K0 == null) {
                H1();
            }
            this.s0.requestFocus();
            return this.q0;
        }
        return (View) invokeLLL.objValue;
    }

    public final void y1(boolean z) {
        EmojiEditText emojiEditText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048602, this, z) == null) || (emojiEditText = this.s0) == null) {
            return;
        }
        if (z) {
            emojiEditText.setPadding(n0.g(8.0f), this.s0.getPaddingTop(), 0, this.s0.getPaddingBottom());
        } else {
            emojiEditText.setPadding(n0.g(8.0f), this.s0.getPaddingTop(), n0.g(8.0f), this.s0.getPaddingBottom());
        }
    }

    public final void z1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            int childCount = this.t0.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.t0.getChildAt(i2);
                if (!(childAt instanceof EmojiEditText)) {
                    this.t0.removeView(childAt);
                }
            }
        }
    }
}

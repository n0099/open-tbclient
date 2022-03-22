package c.a.n0.a.p1;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.p1.j.b;
import c.a.n0.a.p1.j.e;
import c.a.n0.a.p2.q;
import c.a.n0.a.s1.b.b.h;
import c.a.n0.a.x.g.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.publisher.PublishParams;
import com.baidu.swan.apps.publisher.draft.DraftData;
import com.baidu.swan.apps.publisher.emoji.EmojiEditText;
import com.baidu.swan.apps.publisher.view.PhotoChooseView;
import com.baidu.swan.apps.publisher.view.SPSwitchPanelLinearLayout;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c extends c.a.n0.a.x.g.d implements View.OnClickListener, c.a.n0.a.z0.d.d.c<MediaModel>, e.b {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a1;
    public transient /* synthetic */ FieldHolder $fh;
    public SPSwitchPanelLinearLayout F0;
    public EmojiEditText G0;
    public EmojiEditText H0;
    public TextView I0;
    public ImageView J0;
    public PhotoChooseView K0;
    public ImageView L0;
    public TextView M0;
    public TextView N0;
    public ImageView O0;
    public View P0;
    public PublishParams Q0;
    public boolean R0;
    public DraftData S0;
    public c.a.n0.a.p1.a T0;
    public boolean U0;
    public int V0;
    public int W0;
    public int X0;
    public EmojiEditText.e Y0;
    public EmojiEditText.e Z0;

    /* loaded from: classes.dex */
    public class a implements EmojiEditText.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // com.baidu.swan.apps.publisher.emoji.EmojiEditText.e
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.W0 = i;
                int i2 = i - 4999;
                this.a.M0.setVisibility(0);
                if (i2 < 999) {
                    this.a.M0.setText(String.format("超%d字", Integer.valueOf(i2)));
                } else {
                    this.a.M0.setText("超999+");
                }
                this.a.M0.setTextColor(SupportMenu.CATEGORY_MASK);
                this.a.n3();
            }
        }

        @Override // com.baidu.swan.apps.publisher.emoji.EmojiEditText.e
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                this.a.W0 = i;
                if (i <= 4979) {
                    this.a.M0.setVisibility(8);
                } else {
                    this.a.M0.setText(String.format("剩%d字", Integer.valueOf(4999 - i)));
                    this.a.M0.setVisibility(0);
                    this.a.M0.setTextColor(this.a.X0);
                }
                this.a.n3();
            }
        }

        @Override // com.baidu.swan.apps.publisher.emoji.EmojiEditText.e
        public void onBack() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                this.a.t3();
            }
        }
    }

    /* renamed from: c.a.n0.a.p1.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class DialogInterface$OnClickListenerC0412c implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public DialogInterface$OnClickListenerC0412c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                c.a.n0.a.p1.j.c.onEvent("draft_save");
                this.a.S0.setTimeStamp(System.currentTimeMillis());
                this.a.S0.setTitle(this.a.G0.getText().toString());
                this.a.S0.setContent(this.a.H0.getText().toString());
                this.a.S0.setImages(this.a.u3());
                c.a.n0.a.p1.g.a.d(this.a.S0);
                this.a.o3();
                if (this.a.T0 != null) {
                    this.a.T0.onCancel();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public d(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                c.a.n0.a.p1.j.c.onEvent("draft_quit");
                c.a.n0.a.p1.g.a.a();
                this.a.o3();
                if (this.a.T0 != null) {
                    this.a.T0.onCancel();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public e(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // c.a.n0.a.p1.j.b.c
        public void onClickSwitch(View view, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view, z) == null) {
                this.a.l3(z);
                c.a.n0.a.p1.j.c.onEvent("emoji_clk");
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public f(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, view, z) == null) && z) {
                this.a.p3();
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements View.OnKeyListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public g(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, view, i, keyEvent)) == null) {
                return false;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public class h implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public h(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, view, z) == null) && z) {
                this.a.r3();
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public i(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (motionEvent.getAction() == 1) {
                    this.a.m3();
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public class j implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public j(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                this.a.C3(view, motionEvent);
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public class k implements PhotoChooseView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public k(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // com.baidu.swan.apps.publisher.view.PhotoChooseView.b
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i == 0) {
                    this.a.n3();
                }
                if (i == this.a.Q0.getMaxImageNum() - 1) {
                    this.a.s3();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f5731b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f5732c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f5733d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f5734e;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ l a;

            public a(l lVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = lVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.n0.a.s1.b.d.a.d(this.a.f5733d);
                }
            }
        }

        public l(c cVar, List list, String str, String str2, ViewGroup viewGroup) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, list, str, str2, viewGroup};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5734e = cVar;
            this.a = list;
            this.f5731b = str;
            this.f5732c = str2;
            this.f5733d = viewGroup;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONObject a2 = c.a.n0.a.p1.j.a.a(this.a, this.f5734e.Q0.getImageRatio());
                    if (a2 == null) {
                        if (c.a1) {
                            Log.d("SwanAppPublisher", "图片解析失败");
                        }
                        a2 = new JSONObject();
                    }
                    if (!this.f5731b.isEmpty()) {
                        a2.put("title", this.f5734e.G0.getText().toString());
                    }
                    if (!this.f5732c.isEmpty()) {
                        a2.put("content", this.f5734e.H0.getText().toString());
                    }
                    if (c.a1) {
                        Log.d("SwanAppPublisher", "publish result " + a2.toString());
                    }
                    this.f5733d.post(new a(this));
                    c.a.n0.a.p1.g.a.a();
                    this.f5734e.T0.a(a2);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class m implements EmojiEditText.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public m(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // com.baidu.swan.apps.publisher.emoji.EmojiEditText.e
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.V0 = i;
                this.a.G0.setText(this.a.G0.getText().toString().substring(0, 20));
                this.a.G0.setSelection(20);
                c.a.n0.a.p1.j.g.h(this.a.getContext(), R.string.obfuscated_res_0x7f0f12ba);
                this.a.n3();
            }
        }

        @Override // com.baidu.swan.apps.publisher.emoji.EmojiEditText.e
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                this.a.V0 = i;
                if (i == 0) {
                    this.a.O0.setVisibility(8);
                } else {
                    this.a.O0.setVisibility(0);
                }
                this.a.n3();
            }
        }

        @Override // com.baidu.swan.apps.publisher.emoji.EmojiEditText.e
        public void onBack() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1219452017, "Lc/a/n0/a/p1/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1219452017, "Lc/a/n0/a/p1/c;");
                return;
            }
        }
        a1 = c.a.n0.a.a.a;
    }

    public c() {
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
        this.R0 = false;
        this.U0 = false;
        this.V0 = 0;
        this.W0 = 0;
        this.Y0 = new m(this);
        this.Z0 = new a(this);
    }

    public final void A3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (z3()) {
                E3();
                return;
            }
            o3();
            c.a.n0.a.p1.a aVar = this.T0;
            if (aVar != null) {
                aVar.onCancel();
            }
        }
    }

    public void B3(c.a.n0.a.p1.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.T0 = aVar;
        }
    }

    public final void C3(View view, MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, motionEvent) == null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                if (view != null) {
                    view.setAlpha(0.2f);
                }
            } else if (action != 2) {
                if (view != null) {
                    view.setAlpha(1.0f);
                }
            } else if (view != null) {
                view.setAlpha(0.2f);
            }
        }
    }

    public final void D3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            h.a aVar = new h.a(getContext());
            aVar.m(false);
            aVar.U(R.string.obfuscated_res_0x7f0f12b1);
            aVar.v(R.string.obfuscated_res_0x7f0f12b5);
            aVar.O(R.string.obfuscated_res_0x7f0f010f, new b(this));
            aVar.X();
        }
    }

    public final void E3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            h.a aVar = new h.a(getActivity());
            aVar.U(R.string.obfuscated_res_0x7f0f12c5);
            aVar.B(R.string.obfuscated_res_0x7f0f12c2, new d(this));
            aVar.v(R.string.obfuscated_res_0x7f0f12c4);
            aVar.O(R.string.obfuscated_res_0x7f0f12c3, new DialogInterface$OnClickListenerC0412c(this));
            aVar.X();
        }
    }

    @Override // c.a.n0.a.x.g.d
    public boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.U0) {
                if (a1) {
                    Log.d("SwanAppPublisher", "backPress: hide soft");
                }
                c.a.n0.a.p1.j.e.k(this.H0);
                this.U0 = false;
                return true;
            } else if (z3()) {
                if (a1) {
                    Log.d("SwanAppPublisher", "backPress: show draft dialog");
                }
                E3();
                return true;
            } else {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void M0(View view, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, view, bundle) == null) {
            super.M0(view, bundle);
            if (this.R0) {
                D3();
                return;
            }
            y3(view);
            if (this.Q0.supportEmoji().booleanValue() && !TextUtils.isEmpty(this.Q0.getEmojiPath().trim())) {
                x3();
            }
            w3();
            if (this.P0 == null) {
                this.P0 = this.Q0.supportTitle().booleanValue() ? this.G0 : this.H0;
            }
            c.a.n0.a.p1.j.e.n(this.P0, 300L);
            c.a.n0.a.p1.j.c.onEvent("show");
            n3();
        }
    }

    @Override // c.a.n0.a.x.g.d
    public boolean a2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.n0.a.x.g.d
    public boolean c2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.n0.a.z0.d.d.c
    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
        }
    }

    @Override // c.a.n0.a.z0.d.d.c
    public void f(List<MediaModel> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, list) == null) {
            ArrayList arrayList = new ArrayList();
            for (MediaModel mediaModel : list) {
                arrayList.add(mediaModel.getPath());
            }
            this.K0.update(arrayList);
            if (this.Q0.supportTitle().booleanValue() && this.V0 == 0 && this.W0 == 0) {
                c.a.n0.a.p1.j.e.n(this.G0, 300L);
            } else {
                c.a.n0.a.p1.j.e.n(this.H0, 300L);
            }
            n3();
            if (this.K0.getLeftCount() == 0) {
                q3();
            }
        }
    }

    @Override // c.a.n0.a.x.g.d
    public void h2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
        }
    }

    public final void l3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            if (z) {
                this.J0.setImageResource(R.drawable.obfuscated_res_0x7f08118b);
            } else {
                this.J0.setImageResource(R.drawable.obfuscated_res_0x7f08118e);
            }
        }
    }

    public final void m3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            c.a.n0.a.p1.j.b.d(this.F0, this.H0);
            ImageView imageView = this.J0;
            if (imageView != null) {
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f08118e);
            }
        }
    }

    public final void n3() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            List<String> u3 = u3();
            boolean z = !this.Q0.supportTitle().booleanValue() ? ((i2 = this.W0) <= 0 || i2 > 4999) && (u3 == null || u3.size() <= 0) : this.V0 <= 0 || (this.W0 <= 0 && (u3 == null || u3.size() <= 0));
            if (z && !this.N0.isClickable()) {
                this.N0.setClickable(true);
                this.N0.setTextColor(this.Q0.getPublishTextColor());
            } else if (z || !this.N0.isClickable()) {
            } else {
                this.N0.setClickable(false);
                this.N0.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060a81));
            }
        }
    }

    public void o3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            c.a.n0.a.p1.j.e.k(this.H0);
            this.H0.e();
            this.G0.e();
            t3();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, view) == null) {
            int id = view.getId();
            if (id == R.id.obfuscated_res_0x7f09194f) {
                c.a.n0.a.p1.j.c.onEvent("pub_clk");
                v3();
            } else if (id == R.id.obfuscated_res_0x7f09048f) {
                c.a.n0.a.p1.j.c.onEvent("cancel_clk");
                A3();
            } else if (id == R.id.obfuscated_res_0x7f090119) {
                c.a.n0.a.p1.j.c.onEvent("pic_clk_bar");
                c.a.n0.a.p1.j.g.i(this.K0.getLeftCount(), this);
            } else if (id == R.id.obfuscated_res_0x7f090654) {
                this.G0.setText("");
            }
        }
    }

    @Override // c.a.n0.a.p1.j.e.b
    public void onSoftInputShowing(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            if (a1) {
                Log.d("SwanAppPublisher", "soft input is showing ? " + z);
            }
            this.U0 = z;
        }
    }

    public final void p3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.J0.setImageResource(R.drawable.obfuscated_res_0x7f08118d);
            this.J0.setClickable(false);
        }
    }

    public final void q3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.L0.setImageResource(R.drawable.obfuscated_res_0x7f081187);
            this.L0.setClickable(false);
        }
    }

    public final void r3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.J0.setImageResource(R.drawable.obfuscated_res_0x7f08118e);
            this.J0.setClickable(true);
        }
    }

    public final void s3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.L0.setImageResource(R.drawable.obfuscated_res_0x7f081172);
            this.L0.setClickable(true);
        }
    }

    public final void t3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            g.b i2 = c.a.n0.a.w0.f.U().V().i("navigateBack");
            i2.n(c.a.n0.a.x.g.g.i, c.a.n0.a.x.g.g.f7049h);
            i2.g();
            i2.a();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void u0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, bundle) == null) {
            super.u0(bundle);
            Bundle p = p();
            if (p != null) {
                PublishParams publishParams = (PublishParams) p.getParcelable("params");
                this.Q0 = publishParams;
                if (publishParams == null) {
                    this.R0 = true;
                    return;
                }
                return;
            }
            this.R0 = true;
        }
    }

    public final List<String> u3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            if (this.Q0.supportImage().booleanValue()) {
                return this.K0.getData();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    public final void v3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            if (a1) {
                Log.d("SwanAppPublisher", "go publish");
            }
            if (!SwanAppNetworkUtils.i(getContext())) {
                c.a.n0.a.p1.j.g.h(getContext(), R.string.obfuscated_res_0x7f0f12b3);
            } else if (this.T0 == null) {
            } else {
                String obj = this.G0.getText().toString();
                String obj2 = this.H0.getText().toString();
                List<String> u3 = u3();
                if (this.Q0.supportTitle().booleanValue() && TextUtils.isEmpty(obj.trim())) {
                    c.a.n0.a.p1.j.g.h(getContext(), R.string.obfuscated_res_0x7f0f12b0);
                } else if (TextUtils.isEmpty(obj2.trim()) && (u3 == null || u3.size() == 0)) {
                    c.a.n0.a.p1.j.g.h(getContext(), R.string.obfuscated_res_0x7f0f12b0);
                } else if (u3 != null && u3.size() > 0) {
                    ViewGroup viewGroup = (ViewGroup) getActivity().findViewById(16908290);
                    c.a.n0.a.s1.b.d.a.h(getContext(), viewGroup, getResources().getString(R.string.obfuscated_res_0x7f0f12b2));
                    this.N0.setClickable(false);
                    this.N0.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060a81));
                    q.f().execute(new l(this, u3, obj, obj2, viewGroup));
                } else {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (!obj.isEmpty()) {
                            jSONObject.put("title", this.G0.getText().toString());
                        }
                        if (!obj2.isEmpty()) {
                            jSONObject.put("content", this.H0.getText().toString());
                        }
                        if (a1) {
                            Log.d("SwanAppPublisher", "publish result " + jSONObject.toString());
                        }
                        c.a.n0.a.p1.g.a.a();
                        this.T0.a(jSONObject);
                    } catch (JSONException e2) {
                        if (a1) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public final void w3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            DraftData c2 = c.a.n0.a.p1.g.a.c();
            this.S0 = c2;
            if (c2 != null) {
                if (a1) {
                    Log.d("SwanAppPublisher", "update view from draft data");
                }
                String title = this.S0.getTitle();
                if (this.Q0.supportTitle().booleanValue() && !TextUtils.isEmpty(title)) {
                    this.G0.setText(title);
                    this.G0.setSelection(title.length());
                    this.P0 = this.G0;
                }
                String content = this.S0.getContent();
                if (!TextUtils.isEmpty(content)) {
                    this.H0.setText(content);
                    if (this.Q0.supportEmoji().booleanValue() && c.a.n0.a.p1.h.b.c().e()) {
                        this.H0.c();
                    }
                    EmojiEditText emojiEditText = this.H0;
                    emojiEditText.setSelection(emojiEditText.getText().length());
                    this.P0 = this.H0;
                }
                if (this.Q0.supportImage().booleanValue()) {
                    this.K0.update(this.S0.getImages());
                    if (this.K0.getLeftCount() == 0) {
                        q3();
                        return;
                    }
                    return;
                }
                return;
            }
            this.S0 = new DraftData(0L, "", "", null);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View x0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048603, this, layoutInflater, viewGroup, bundle)) == null) {
            super.x0(layoutInflater, viewGroup, bundle);
            return layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d07df, viewGroup, false);
        }
        return (View) invokeLLL.objValue;
    }

    public final void x3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            c.a.n0.a.p1.j.e.c(getActivity(), (ViewGroup) getActivity().findViewById(16908290), this.F0, this);
            c.a.n0.a.p1.j.b.b(this.F0, this.J0, this.H0, new e(this));
            c.a.n0.a.p1.h.d.b().c(getActivity(), this.F0, this.H0, this.Q0.getEmojiPath(), this.Q0.getAppId(), this.Q0.getAppVersion());
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void y3(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, view) == null) {
            if (a1) {
                Log.d("SwanAppPublisher", "init view");
            }
            this.G0 = (EmojiEditText) view.findViewById(R.id.obfuscated_res_0x7f0918ce);
            if (this.Q0.supportTitle().booleanValue()) {
                view.findViewById(R.id.obfuscated_res_0x7f0918cf).setVisibility(0);
                this.G0.setHint(this.Q0.getTitleHint());
                this.G0.setListener(this.Y0);
                this.G0.setMaxSize(20);
                this.G0.setOnFocusChangeListener(new f(this));
            } else {
                view.findViewById(R.id.obfuscated_res_0x7f0918cf).setVisibility(8);
            }
            this.J0 = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f090102);
            if (this.Q0.supportEmoji().booleanValue() && !TextUtils.isEmpty(this.Q0.getEmojiPath().trim())) {
                this.J0.setVisibility(0);
            } else {
                this.J0.setVisibility(8);
            }
            this.F0 = (SPSwitchPanelLinearLayout) view.findViewById(R.id.obfuscated_res_0x7f090869);
            view.findViewById(R.id.obfuscated_res_0x7f0914f3).setBackgroundColor(this.Q0.getNavBarBgColor());
            TextView textView = (TextView) view.findViewById(R.id.obfuscated_res_0x7f09195d);
            textView.setText(this.Q0.getNavBarTitle());
            textView.setTextColor(this.Q0.getNavBarTextColor());
            ImageView imageView = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f090654);
            this.O0 = imageView;
            imageView.setOnClickListener(this);
            this.I0 = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0918ca);
            if (this.Q0.supportTarget().booleanValue() && !TextUtils.isEmpty(this.Q0.getTarget().trim())) {
                TextView textView2 = this.I0;
                textView2.setText("发布到 " + this.Q0.getTarget());
            } else {
                view.findViewById(R.id.obfuscated_res_0x7f0918cb).setVisibility(8);
            }
            this.M0 = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091f43);
            EmojiEditText emojiEditText = (EmojiEditText) view.findViewById(R.id.obfuscated_res_0x7f0918ac);
            this.H0 = emojiEditText;
            emojiEditText.setOnKeyListener(new g(this));
            this.H0.setHint(this.Q0.getContentHint());
            this.H0.setListener(this.Z0);
            this.H0.setMaxSize(4999);
            this.H0.setOnFocusChangeListener(new h(this));
            view.findViewById(R.id.obfuscated_res_0x7f0906e4).setOnTouchListener(new i(this));
            TextView textView3 = (TextView) view.findViewById(R.id.obfuscated_res_0x7f09194f);
            this.N0 = textView3;
            textView3.setText(this.Q0.getPublishText());
            this.N0.setOnClickListener(this);
            this.N0.setClickable(false);
            TextView textView4 = (TextView) view.findViewById(R.id.obfuscated_res_0x7f09048f);
            textView4.setText(this.Q0.getCancelText());
            textView4.setTextColor(this.Q0.getCancelTextColor());
            textView4.setOnClickListener(this);
            textView4.setOnTouchListener(new j(this));
            this.L0 = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f090119);
            this.K0 = (PhotoChooseView) view.findViewById(R.id.obfuscated_res_0x7f091831);
            if (this.Q0.supportImage().booleanValue()) {
                this.L0.setVisibility(0);
                this.L0.setOnClickListener(this);
                this.K0.setVisibility(0);
                this.K0.d(getActivity());
                this.K0.setMaxCount(this.Q0.getMaxImageNum());
                this.K0.setCallback(this);
                this.K0.setDeleteListener(new k(this));
            } else {
                this.L0.setVisibility(8);
                this.K0.setVisibility(8);
            }
            this.X0 = getResources().getColor(R.color.obfuscated_res_0x7f060a80);
        }
    }

    public final boolean z3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            String trim = this.Q0.supportTitle().booleanValue() ? this.G0.getText().toString().trim() : "";
            String trim2 = this.H0.getText().toString().trim();
            List<String> u3 = u3();
            if (TextUtils.isEmpty(trim) && TextUtils.isEmpty(trim2) && u3 == null) {
                c.a.n0.a.p1.g.a.a();
                return false;
            }
            if (TextUtils.equals(trim, this.S0.getTitle()) && TextUtils.equals(trim2, this.S0.getContent())) {
                List<String> images = this.S0.getImages();
                if (images == null && u3 == null) {
                    return false;
                }
                if (images != null && u3 != null && images.size() == u3.size()) {
                    for (int i2 = 0; i2 < u3.size(); i2++) {
                        if (!TextUtils.equals(images.get(i2), u3.get(i2))) {
                            return true;
                        }
                    }
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}

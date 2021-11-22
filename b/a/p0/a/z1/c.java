package b.a.p0.a.z1;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.h0.g.g;
import b.a.p0.a.z1.j.b;
import b.a.p0.a.z1.j.e;
import b.a.p0.a.z2.q;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.publisher.PublishParams;
import com.baidu.swan.apps.publisher.draft.DraftData;
import com.baidu.swan.apps.publisher.emoji.EmojiEditText;
import com.baidu.swan.apps.publisher.view.PhotoChooseView;
import com.baidu.swan.apps.publisher.view.SPSwitchPanelLinearLayout;
import com.baidu.swan.apps.res.widget.dialog.SwanAppAlertDialog;
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
public class c extends b.a.p0.a.h0.g.d implements View.OnClickListener, b.a.p0.a.j1.d.d.c<MediaModel>, e.b {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d1;
    public transient /* synthetic */ FieldHolder $fh;
    public SPSwitchPanelLinearLayout I0;
    public EmojiEditText J0;
    public EmojiEditText K0;
    public TextView L0;
    public ImageView M0;
    public PhotoChooseView N0;
    public ImageView O0;
    public TextView P0;
    public TextView Q0;
    public ImageView R0;
    public View S0;
    public PublishParams T0;
    public boolean U0;
    public DraftData V0;
    public b.a.p0.a.z1.a W0;
    public boolean X0;
    public int Y0;
    public int Z0;
    public int a1;
    public EmojiEditText.e b1;
    public EmojiEditText.e c1;

    /* loaded from: classes.dex */
    public class a implements EmojiEditText.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f9620a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9620a = cVar;
        }

        @Override // com.baidu.swan.apps.publisher.emoji.EmojiEditText.e
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f9620a.Z0 = i2;
                int i3 = i2 - 4999;
                this.f9620a.P0.setVisibility(0);
                if (i3 < 999) {
                    this.f9620a.P0.setText(String.format("超%d字", Integer.valueOf(i3)));
                } else {
                    this.f9620a.P0.setText("超999+");
                }
                this.f9620a.P0.setTextColor(SupportMenu.CATEGORY_MASK);
                this.f9620a.m3();
            }
        }

        @Override // com.baidu.swan.apps.publisher.emoji.EmojiEditText.e
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                this.f9620a.Z0 = i2;
                if (i2 <= 4979) {
                    this.f9620a.P0.setVisibility(8);
                } else {
                    this.f9620a.P0.setText(String.format("剩%d字", Integer.valueOf(4999 - i2)));
                    this.f9620a.P0.setVisibility(0);
                    this.f9620a.P0.setTextColor(this.f9620a.a1);
                }
                this.f9620a.m3();
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

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f9621e;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9621e = cVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                this.f9621e.s3();
            }
        }
    }

    /* renamed from: b.a.p0.a.z1.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class DialogInterface$OnClickListenerC0498c implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f9622e;

        public DialogInterface$OnClickListenerC0498c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9622e = cVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                b.a.p0.a.z1.j.c.onEvent("draft_save");
                this.f9622e.V0.setTimeStamp(System.currentTimeMillis());
                this.f9622e.V0.setTitle(this.f9622e.J0.getText().toString());
                this.f9622e.V0.setContent(this.f9622e.K0.getText().toString());
                this.f9622e.V0.setImages(this.f9622e.t3());
                b.a.p0.a.z1.g.a.d(this.f9622e.V0);
                this.f9622e.n3();
                if (this.f9622e.W0 != null) {
                    this.f9622e.W0.onCancel();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f9623e;

        public d(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9623e = cVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                b.a.p0.a.z1.j.c.onEvent("draft_quit");
                b.a.p0.a.z1.g.a.a();
                this.f9623e.n3();
                if (this.f9623e.W0 != null) {
                    this.f9623e.W0.onCancel();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f9624a;

        public e(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9624a = cVar;
        }

        @Override // b.a.p0.a.z1.j.b.c
        public void onClickSwitch(View view, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view, z) == null) {
                this.f9624a.k3(z);
                b.a.p0.a.z1.j.c.onEvent("emoji_clk");
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f9625e;

        public f(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9625e = cVar;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, view, z) == null) && z) {
                this.f9625e.o3();
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements View.OnKeyListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i2, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, view, i2, keyEvent)) == null) {
                return false;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public class h implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f9626e;

        public h(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9626e = cVar;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, view, z) == null) && z) {
                this.f9626e.q3();
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f9627e;

        public i(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9627e = cVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (motionEvent.getAction() == 1) {
                    this.f9627e.l3();
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

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f9628e;

        public j(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9628e = cVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                this.f9628e.B3(view, motionEvent);
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public class k implements PhotoChooseView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f9629a;

        public k(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9629a = cVar;
        }

        @Override // com.baidu.swan.apps.publisher.view.PhotoChooseView.b
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 == 0) {
                    this.f9629a.m3();
                }
                if (i2 == this.f9629a.T0.getMaxImageNum() - 1) {
                    this.f9629a.r3();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f9630e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f9631f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f9632g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f9633h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c f9634i;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ l f9635e;

            public a(l lVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f9635e = lVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    b.a.p0.a.c2.b.d.a.d(this.f9635e.f9633h);
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9634i = cVar;
            this.f9630e = list;
            this.f9631f = str;
            this.f9632g = str2;
            this.f9633h = viewGroup;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONObject a2 = b.a.p0.a.z1.j.a.a(this.f9630e, this.f9634i.T0.getImageRatio());
                    if (a2 == null) {
                        boolean z = c.d1;
                        a2 = new JSONObject();
                    }
                    if (!this.f9631f.isEmpty()) {
                        a2.put("title", this.f9634i.J0.getText().toString());
                    }
                    if (!this.f9632g.isEmpty()) {
                        a2.put("content", this.f9634i.K0.getText().toString());
                    }
                    if (c.d1) {
                        String str = "publish result " + a2.toString();
                    }
                    this.f9633h.post(new a(this));
                    b.a.p0.a.z1.g.a.a();
                    this.f9634i.W0.a(a2);
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

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f9636a;

        public m(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9636a = cVar;
        }

        @Override // com.baidu.swan.apps.publisher.emoji.EmojiEditText.e
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f9636a.Y0 = i2;
                this.f9636a.J0.setText(this.f9636a.J0.getText().toString().substring(0, 20));
                this.f9636a.J0.setSelection(20);
                b.a.p0.a.z1.j.g.h(this.f9636a.getContext(), b.a.p0.a.h.swanapp_publisher_title_exceed);
                this.f9636a.m3();
            }
        }

        @Override // com.baidu.swan.apps.publisher.emoji.EmojiEditText.e
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                this.f9636a.Y0 = i2;
                if (i2 == 0) {
                    this.f9636a.R0.setVisibility(8);
                } else {
                    this.f9636a.R0.setVisibility(0);
                }
                this.f9636a.m3();
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1341218842, "Lb/a/p0/a/z1/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1341218842, "Lb/a/p0/a/z1/c;");
                return;
            }
        }
        d1 = b.a.p0.a.k.f6863a;
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
        this.U0 = false;
        this.X0 = false;
        this.Y0 = 0;
        this.Z0 = 0;
        this.b1 = new m(this);
        this.c1 = new a(this);
    }

    public void A3(b.a.p0.a.z1.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.W0 = aVar;
        }
    }

    public final void B3(View view, MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, motionEvent) == null) {
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

    public final void C3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SwanAppAlertDialog.a aVar = new SwanAppAlertDialog.a(getContext());
            aVar.m(false);
            aVar.U(b.a.p0.a.h.swanapp_publisher_error_title);
            aVar.v(b.a.p0.a.h.swanapp_publisher_params_error);
            aVar.O(b.a.p0.a.h.aiapps_confirm, new b(this));
            aVar.X();
        }
    }

    public final void D3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            SwanAppAlertDialog.a aVar = new SwanAppAlertDialog.a(getActivity());
            aVar.U(b.a.p0.a.h.swanapp_save_draft_dialog_title);
            aVar.B(b.a.p0.a.h.swanapp_save_draft_dialog_btn_negative, new d(this));
            aVar.v(b.a.p0.a.h.swanapp_save_draft_dialog_message);
            aVar.O(b.a.p0.a.h.swanapp_save_draft_dialog_btn_positive, new DialogInterface$OnClickListenerC0498c(this));
            aVar.X();
        }
    }

    @Override // b.a.p0.a.h0.g.d
    public boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.X0) {
                boolean z = d1;
                b.a.p0.a.z1.j.e.k(this.K0);
                this.X0 = false;
                return true;
            } else if (y3()) {
                boolean z2 = d1;
                D3();
                return true;
            } else {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void L0(View view, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, view, bundle) == null) {
            super.L0(view, bundle);
            if (this.U0) {
                C3();
                return;
            }
            x3(view);
            if (this.T0.supportEmoji().booleanValue() && !TextUtils.isEmpty(this.T0.getEmojiPath().trim())) {
                w3();
            }
            v3();
            if (this.S0 == null) {
                this.S0 = this.T0.supportTitle().booleanValue() ? this.J0 : this.K0;
            }
            b.a.p0.a.z1.j.e.n(this.S0, 300L);
            b.a.p0.a.z1.j.c.onEvent("show");
            m3();
        }
    }

    @Override // b.a.p0.a.h0.g.d
    public boolean Z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.p0.a.h0.g.d
    public boolean b2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.p0.a.j1.d.d.c
    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
        }
    }

    @Override // b.a.p0.a.j1.d.d.c
    public void f(List<MediaModel> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            ArrayList arrayList = new ArrayList();
            for (MediaModel mediaModel : list) {
                arrayList.add(mediaModel.getPath());
            }
            this.N0.update(arrayList);
            if (this.T0.supportTitle().booleanValue() && this.Y0 == 0 && this.Z0 == 0) {
                b.a.p0.a.z1.j.e.n(this.J0, 300L);
            } else {
                b.a.p0.a.z1.j.e.n(this.K0, 300L);
            }
            m3();
            if (this.N0.getLeftCount() == 0) {
                p3();
            }
        }
    }

    @Override // b.a.p0.a.h0.g.d
    public void g2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
        }
    }

    public final void k3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            if (z) {
                this.M0.setImageResource(b.a.p0.a.e.swanapp_ugc_keyboard_selector);
            } else {
                this.M0.setImageResource(b.a.p0.a.e.swanapp_ugc_switch_soft_emoji_selector);
            }
        }
    }

    public final void l3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            b.a.p0.a.z1.j.b.d(this.I0, this.K0);
            ImageView imageView = this.M0;
            if (imageView != null) {
                imageView.setImageResource(b.a.p0.a.e.swanapp_ugc_switch_soft_emoji_selector);
            }
        }
    }

    public final void m3() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            List<String> t3 = t3();
            boolean z = !this.T0.supportTitle().booleanValue() ? ((i2 = this.Z0) <= 0 || i2 > 4999) && (t3 == null || t3.size() <= 0) : this.Y0 <= 0 || (this.Z0 <= 0 && (t3 == null || t3.size() <= 0));
            if (z && !this.Q0.isClickable()) {
                this.Q0.setClickable(true);
                this.Q0.setTextColor(this.T0.getPublishTextColor());
            } else if (z || !this.Q0.isClickable()) {
            } else {
                this.Q0.setClickable(false);
                this.Q0.setTextColor(getResources().getColor(b.a.p0.a.c.swanapp_ugc_publish_no_able_color));
            }
        }
    }

    public void n3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            b.a.p0.a.z1.j.e.k(this.K0);
            this.K0.removeListener();
            this.J0.removeListener();
            s3();
        }
    }

    public final void o3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.M0.setImageResource(b.a.p0.a.e.swanapp_ugc_switch_soft_emoji_pressed);
            this.M0.setClickable(false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, view) == null) {
            int id = view.getId();
            if (id == b.a.p0.a.f.publish_button) {
                b.a.p0.a.z1.j.c.onEvent("pub_clk");
                u3();
            } else if (id == b.a.p0.a.f.cancel_button) {
                b.a.p0.a.z1.j.c.onEvent("cancel_clk");
                z3();
            } else if (id == b.a.p0.a.f.add_picture) {
                b.a.p0.a.z1.j.c.onEvent("pic_clk_bar");
                b.a.p0.a.z1.j.g.i(this.N0.getLeftCount(), this);
            } else if (id == b.a.p0.a.f.clear_title) {
                this.J0.setText("");
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bundle) == null) {
            super.onCreate(bundle);
            Bundle o = o();
            if (o != null) {
                PublishParams publishParams = (PublishParams) o.getParcelable("params");
                this.T0 = publishParams;
                if (publishParams == null) {
                    this.U0 = true;
                    return;
                }
                return;
            }
            this.U0 = true;
        }
    }

    @Override // b.a.p0.a.z1.j.e.b
    public void onSoftInputShowing(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            if (d1) {
                String str = "soft input is showing ? " + z;
            }
            this.X0 = z;
        }
    }

    public final void p3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.O0.setImageResource(b.a.p0.a.e.swanapp_ugc_choose_photo_pressed);
            this.O0.setClickable(false);
        }
    }

    public final void q3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.M0.setImageResource(b.a.p0.a.e.swanapp_ugc_switch_soft_emoji_selector);
            this.M0.setClickable(true);
        }
    }

    public final void r3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.O0.setImageResource(b.a.p0.a.e.swanapp_publisher_photo_choose_selector);
            this.O0.setClickable(true);
        }
    }

    public final void s3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            g.b i2 = b.a.p0.a.g1.f.U().V().i("navigateBack");
            i2.n(b.a.p0.a.h0.g.g.f5480i, b.a.p0.a.h0.g.g.f5479h);
            i2.g();
            i2.a();
        }
    }

    public final List<String> t3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            if (this.T0.supportImage().booleanValue()) {
                return this.N0.getData();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    public final void u3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            boolean z = d1;
            if (!SwanAppNetworkUtils.i(getContext())) {
                b.a.p0.a.z1.j.g.h(getContext(), b.a.p0.a.h.swanapp_publisher_image_upload_fail);
            } else if (this.W0 == null) {
            } else {
                String obj = this.J0.getText().toString();
                String obj2 = this.K0.getText().toString();
                List<String> t3 = t3();
                if (this.T0.supportTitle().booleanValue() && TextUtils.isEmpty(obj.trim())) {
                    b.a.p0.a.z1.j.g.h(getContext(), b.a.p0.a.h.swanapp_publisher_error_empty);
                } else if (TextUtils.isEmpty(obj2.trim()) && (t3 == null || t3.size() == 0)) {
                    b.a.p0.a.z1.j.g.h(getContext(), b.a.p0.a.h.swanapp_publisher_error_empty);
                } else if (t3 != null && t3.size() > 0) {
                    ViewGroup viewGroup = (ViewGroup) getActivity().findViewById(16908290);
                    b.a.p0.a.c2.b.d.a.h(getContext(), viewGroup, getResources().getString(b.a.p0.a.h.swanapp_publisher_handling_pictures));
                    this.Q0.setClickable(false);
                    this.Q0.setTextColor(getResources().getColor(b.a.p0.a.c.swanapp_ugc_publish_no_able_color));
                    q.f().execute(new l(this, t3, obj, obj2, viewGroup));
                } else {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (!obj.isEmpty()) {
                            jSONObject.put("title", this.J0.getText().toString());
                        }
                        if (!obj2.isEmpty()) {
                            jSONObject.put("content", this.K0.getText().toString());
                        }
                        if (d1) {
                            String str = "publish result " + jSONObject.toString();
                        }
                        b.a.p0.a.z1.g.a.a();
                        this.W0.a(jSONObject);
                    } catch (JSONException e2) {
                        if (d1) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public final void v3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            DraftData c2 = b.a.p0.a.z1.g.a.c();
            this.V0 = c2;
            if (c2 != null) {
                boolean z = d1;
                String title = this.V0.getTitle();
                if (this.T0.supportTitle().booleanValue() && !TextUtils.isEmpty(title)) {
                    this.J0.setText(title);
                    this.J0.setSelection(title.length());
                    this.S0 = this.J0;
                }
                String content = this.V0.getContent();
                if (!TextUtils.isEmpty(content)) {
                    this.K0.setText(content);
                    if (this.T0.supportEmoji().booleanValue() && b.a.p0.a.z1.h.b.c().e()) {
                        this.K0.handleDraftEmojiDisplay();
                    }
                    EmojiEditText emojiEditText = this.K0;
                    emojiEditText.setSelection(emojiEditText.getText().length());
                    this.S0 = this.K0;
                }
                if (this.T0.supportImage().booleanValue()) {
                    this.N0.update(this.V0.getImages());
                    if (this.N0.getLeftCount() == 0) {
                        p3();
                        return;
                    }
                    return;
                }
                return;
            }
            this.V0 = new DraftData(0L, "", "", null);
        }
    }

    public final void w3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            b.a.p0.a.z1.j.e.c(getActivity(), (ViewGroup) getActivity().findViewById(16908290), this.I0, this);
            b.a.p0.a.z1.j.b.b(this.I0, this.M0, this.K0, new e(this));
            b.a.p0.a.z1.h.d.b().c(getActivity(), this.I0, this.K0, this.T0.getEmojiPath(), this.T0.getAppId(), this.T0.getAppVersion());
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void x3(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, view) == null) {
            boolean z = d1;
            this.J0 = (EmojiEditText) view.findViewById(b.a.p0.a.f.post_title);
            if (this.T0.supportTitle().booleanValue()) {
                view.findViewById(b.a.p0.a.f.post_title_layout).setVisibility(0);
                this.J0.setHint(this.T0.getTitleHint());
                this.J0.setListener(this.b1);
                this.J0.setMaxSize(20);
                this.J0.setOnFocusChangeListener(new f(this));
            } else {
                view.findViewById(b.a.p0.a.f.post_title_layout).setVisibility(8);
            }
            this.M0 = (ImageView) view.findViewById(b.a.p0.a.f.add_emoij);
            if (this.T0.supportEmoji().booleanValue() && !TextUtils.isEmpty(this.T0.getEmojiPath().trim())) {
                this.M0.setVisibility(0);
            } else {
                this.M0.setVisibility(8);
            }
            this.I0 = (SPSwitchPanelLinearLayout) view.findViewById(b.a.p0.a.f.emoji_panel_root);
            view.findViewById(b.a.p0.a.f.nav_bar).setBackgroundColor(this.T0.getNavBarBgColor());
            TextView textView = (TextView) view.findViewById(b.a.p0.a.f.publish_title);
            textView.setText(this.T0.getNavBarTitle());
            textView.setTextColor(this.T0.getNavBarTextColor());
            ImageView imageView = (ImageView) view.findViewById(b.a.p0.a.f.clear_title);
            this.R0 = imageView;
            imageView.setOnClickListener(this);
            this.L0 = (TextView) view.findViewById(b.a.p0.a.f.post_target);
            if (this.T0.supportTarget().booleanValue() && !TextUtils.isEmpty(this.T0.getTarget().trim())) {
                TextView textView2 = this.L0;
                textView2.setText("发布到 " + this.T0.getTarget());
            } else {
                view.findViewById(b.a.p0.a.f.post_target_layout).setVisibility(8);
            }
            this.P0 = (TextView) view.findViewById(b.a.p0.a.f.text_number);
            EmojiEditText emojiEditText = (EmojiEditText) view.findViewById(b.a.p0.a.f.post_content);
            this.K0 = emojiEditText;
            emojiEditText.setOnKeyListener(new g(this));
            this.K0.setHint(this.T0.getContentHint());
            this.K0.setListener(this.c1);
            this.K0.setMaxSize(4999);
            this.K0.setOnFocusChangeListener(new h(this));
            view.findViewById(b.a.p0.a.f.content_scroll_layout).setOnTouchListener(new i(this));
            TextView textView3 = (TextView) view.findViewById(b.a.p0.a.f.publish_button);
            this.Q0 = textView3;
            textView3.setText(this.T0.getPublishText());
            this.Q0.setOnClickListener(this);
            this.Q0.setClickable(false);
            TextView textView4 = (TextView) view.findViewById(b.a.p0.a.f.cancel_button);
            textView4.setText(this.T0.getCancelText());
            textView4.setTextColor(this.T0.getCancelTextColor());
            textView4.setOnClickListener(this);
            textView4.setOnTouchListener(new j(this));
            this.O0 = (ImageView) view.findViewById(b.a.p0.a.f.add_picture);
            this.N0 = (PhotoChooseView) view.findViewById(b.a.p0.a.f.pic_choose);
            if (this.T0.supportImage().booleanValue()) {
                this.O0.setVisibility(0);
                this.O0.setOnClickListener(this);
                this.N0.setVisibility(0);
                this.N0.init(getActivity());
                this.N0.setMaxCount(this.T0.getMaxImageNum());
                this.N0.setCallback(this);
                this.N0.setDeleteListener(new k(this));
            } else {
                this.O0.setVisibility(8);
                this.N0.setVisibility(8);
            }
            this.a1 = getResources().getColor(b.a.p0.a.c.swanapp_text_number_color);
        }
    }

    public final boolean y3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            String trim = this.T0.supportTitle().booleanValue() ? this.J0.getText().toString().trim() : "";
            String trim2 = this.K0.getText().toString().trim();
            List<String> t3 = t3();
            if (TextUtils.isEmpty(trim) && TextUtils.isEmpty(trim2) && t3 == null) {
                b.a.p0.a.z1.g.a.a();
                return false;
            }
            if (TextUtils.equals(trim, this.V0.getTitle()) && TextUtils.equals(trim2, this.V0.getContent())) {
                List<String> images = this.V0.getImages();
                if (images == null && t3 == null) {
                    return false;
                }
                if (images != null && t3 != null && images.size() == t3.size()) {
                    for (int i2 = 0; i2 < t3.size(); i2++) {
                        if (!TextUtils.equals(images.get(i2), t3.get(i2))) {
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

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View z0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048605, this, layoutInflater, viewGroup, bundle)) == null) {
            super.z0(layoutInflater, viewGroup, bundle);
            return layoutInflater.inflate(b.a.p0.a.g.swanapp_publisher_layout, viewGroup, false);
        }
        return (View) invokeLLL.objValue;
    }

    public final void z3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            if (y3()) {
                D3();
                return;
            }
            n3();
            b.a.p0.a.z1.a aVar = this.W0;
            if (aVar != null) {
                aVar.onCancel();
            }
        }
    }
}

package c.a.r0.a.z1;

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
import c.a.r0.a.h0.g.g;
import c.a.r0.a.z1.j.b;
import c.a.r0.a.z1.j.e;
import c.a.r0.a.z2.q;
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
public class c extends c.a.r0.a.h0.g.d implements View.OnClickListener, c.a.r0.a.j1.d.d.c<MediaModel>, e.b {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean e1;
    public transient /* synthetic */ FieldHolder $fh;
    public SPSwitchPanelLinearLayout J0;
    public EmojiEditText K0;
    public EmojiEditText L0;
    public TextView M0;
    public ImageView N0;
    public PhotoChooseView O0;
    public ImageView P0;
    public TextView Q0;
    public TextView R0;
    public ImageView S0;
    public View T0;
    public PublishParams U0;
    public boolean V0;
    public DraftData W0;
    public c.a.r0.a.z1.a X0;
    public boolean Y0;
    public int Z0;
    public int a1;
    public int b1;
    public EmojiEditText.e c1;
    public EmojiEditText.e d1;

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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // com.baidu.swan.apps.publisher.emoji.EmojiEditText.e
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.a.a1 = i2;
                int i3 = i2 - 4999;
                this.a.Q0.setVisibility(0);
                if (i3 < 999) {
                    this.a.Q0.setText(String.format("超%d字", Integer.valueOf(i3)));
                } else {
                    this.a.Q0.setText("超999+");
                }
                this.a.Q0.setTextColor(SupportMenu.CATEGORY_MASK);
                this.a.j3();
            }
        }

        @Override // com.baidu.swan.apps.publisher.emoji.EmojiEditText.e
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                this.a.a1 = i2;
                if (i2 <= 4979) {
                    this.a.Q0.setVisibility(8);
                } else {
                    this.a.Q0.setText(String.format("剩%d字", Integer.valueOf(4999 - i2)));
                    this.a.Q0.setVisibility(0);
                    this.a.Q0.setTextColor(this.a.b1);
                }
                this.a.j3();
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
        public final /* synthetic */ c f9847e;

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
            this.f9847e = cVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                this.f9847e.p3();
            }
        }
    }

    /* renamed from: c.a.r0.a.z1.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class DialogInterface$OnClickListenerC0647c implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f9848e;

        public DialogInterface$OnClickListenerC0647c(c cVar) {
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
            this.f9848e = cVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                c.a.r0.a.z1.j.c.onEvent("draft_save");
                this.f9848e.W0.setTimeStamp(System.currentTimeMillis());
                this.f9848e.W0.setTitle(this.f9848e.K0.getText().toString());
                this.f9848e.W0.setContent(this.f9848e.L0.getText().toString());
                this.f9848e.W0.setImages(this.f9848e.q3());
                c.a.r0.a.z1.g.a.d(this.f9848e.W0);
                this.f9848e.k3();
                if (this.f9848e.X0 != null) {
                    this.f9848e.X0.onCancel();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f9849e;

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
            this.f9849e = cVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                c.a.r0.a.z1.j.c.onEvent("draft_quit");
                c.a.r0.a.z1.g.a.a();
                this.f9849e.k3();
                if (this.f9849e.X0 != null) {
                    this.f9849e.X0.onCancel();
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // c.a.r0.a.z1.j.b.c
        public void onClickSwitch(View view, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view, z) == null) {
                this.a.h3(z);
                c.a.r0.a.z1.j.c.onEvent("emoji_clk");
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f9850e;

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
            this.f9850e = cVar;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, view, z) == null) && z) {
                this.f9850e.l3();
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements View.OnKeyListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f9851e;

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
                    return;
                }
            }
            this.f9851e = cVar;
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
        public final /* synthetic */ c f9852e;

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
            this.f9852e = cVar;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, view, z) == null) && z) {
                this.f9852e.n3();
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f9853e;

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
            this.f9853e = cVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (motionEvent.getAction() == 1) {
                    this.f9853e.i3();
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
        public final /* synthetic */ c f9854e;

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
            this.f9854e = cVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                this.f9854e.y3(view, motionEvent);
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // com.baidu.swan.apps.publisher.view.PhotoChooseView.b
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 == 0) {
                    this.a.j3();
                }
                if (i2 == this.a.U0.getMaxImageNum() - 1) {
                    this.a.o3();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f9855e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f9856f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f9857g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f9858h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c f9859i;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ l f9860e;

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
                this.f9860e = lVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.r0.a.c2.b.d.a.d(this.f9860e.f9858h);
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
            this.f9859i = cVar;
            this.f9855e = list;
            this.f9856f = str;
            this.f9857g = str2;
            this.f9858h = viewGroup;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONObject a2 = c.a.r0.a.z1.j.a.a(this.f9855e, this.f9859i.U0.getImageRatio());
                    if (a2 == null) {
                        boolean z = c.e1;
                        a2 = new JSONObject();
                    }
                    if (!this.f9856f.isEmpty()) {
                        a2.put("title", this.f9859i.K0.getText().toString());
                    }
                    if (!this.f9857g.isEmpty()) {
                        a2.put("content", this.f9859i.L0.getText().toString());
                    }
                    if (c.e1) {
                        String str = "publish result " + a2.toString();
                    }
                    this.f9858h.post(new a(this));
                    c.a.r0.a.z1.g.a.a();
                    this.f9859i.X0.a(a2);
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // com.baidu.swan.apps.publisher.emoji.EmojiEditText.e
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.a.Z0 = i2;
                this.a.K0.setText(this.a.K0.getText().toString().substring(0, 20));
                this.a.K0.setSelection(20);
                c.a.r0.a.z1.j.g.h(this.a.getContext(), c.a.r0.a.h.swanapp_publisher_title_exceed);
                this.a.j3();
            }
        }

        @Override // com.baidu.swan.apps.publisher.emoji.EmojiEditText.e
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                this.a.Z0 = i2;
                if (i2 == 0) {
                    this.a.S0.setVisibility(8);
                } else {
                    this.a.S0.setVisibility(0);
                }
                this.a.j3();
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(442633207, "Lc/a/r0/a/z1/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(442633207, "Lc/a/r0/a/z1/c;");
                return;
            }
        }
        e1 = c.a.r0.a.k.a;
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
        this.V0 = false;
        this.Y0 = false;
        this.Z0 = 0;
        this.a1 = 0;
        this.c1 = new m(this);
        this.d1 = new a(this);
    }

    public final void A3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SwanAppAlertDialog.a aVar = new SwanAppAlertDialog.a(getActivity());
            aVar.U(c.a.r0.a.h.swanapp_save_draft_dialog_title);
            aVar.B(c.a.r0.a.h.swanapp_save_draft_dialog_btn_negative, new d(this));
            aVar.v(c.a.r0.a.h.swanapp_save_draft_dialog_message);
            aVar.O(c.a.r0.a.h.swanapp_save_draft_dialog_btn_positive, new DialogInterface$OnClickListenerC0647c(this));
            aVar.X();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void I0(View view, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, bundle) == null) {
            super.I0(view, bundle);
            if (this.V0) {
                z3();
                return;
            }
            u3(view);
            if (this.U0.supportEmoji().booleanValue() && !TextUtils.isEmpty(this.U0.getEmojiPath().trim())) {
                t3();
            }
            s3();
            if (this.T0 == null) {
                this.T0 = this.U0.supportTitle().booleanValue() ? this.K0 : this.L0;
            }
            c.a.r0.a.z1.j.e.n(this.T0, 300L);
            c.a.r0.a.z1.j.c.onEvent("show");
            j3();
        }
    }

    @Override // c.a.r0.a.h0.g.d
    public boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.Y0) {
                boolean z = e1;
                c.a.r0.a.z1.j.e.k(this.L0);
                this.Y0 = false;
                return true;
            } else if (v3()) {
                boolean z2 = e1;
                A3();
                return true;
            } else {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.r0.a.h0.g.d
    public boolean W1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.r0.a.h0.g.d
    public boolean Y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.r0.a.h0.g.d
    public void d2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    @Override // c.a.r0.a.j1.d.d.c
    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
        }
    }

    public final void h3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            if (z) {
                this.N0.setImageResource(c.a.r0.a.e.swanapp_ugc_keyboard_selector);
            } else {
                this.N0.setImageResource(c.a.r0.a.e.swanapp_ugc_switch_soft_emoji_selector);
            }
        }
    }

    public final void i3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            c.a.r0.a.z1.j.b.d(this.J0, this.L0);
            ImageView imageView = this.N0;
            if (imageView != null) {
                imageView.setImageResource(c.a.r0.a.e.swanapp_ugc_switch_soft_emoji_selector);
            }
        }
    }

    @Override // c.a.r0.a.j1.d.d.c
    public void j(List<MediaModel> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            ArrayList arrayList = new ArrayList();
            for (MediaModel mediaModel : list) {
                arrayList.add(mediaModel.getPath());
            }
            this.O0.update(arrayList);
            if (this.U0.supportTitle().booleanValue() && this.Z0 == 0 && this.a1 == 0) {
                c.a.r0.a.z1.j.e.n(this.K0, 300L);
            } else {
                c.a.r0.a.z1.j.e.n(this.L0, 300L);
            }
            j3();
            if (this.O0.getLeftCount() == 0) {
                m3();
            }
        }
    }

    public final void j3() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            List<String> q3 = q3();
            boolean z = !this.U0.supportTitle().booleanValue() ? ((i2 = this.a1) <= 0 || i2 > 4999) && (q3 == null || q3.size() <= 0) : this.Z0 <= 0 || (this.a1 <= 0 && (q3 == null || q3.size() <= 0));
            if (z && !this.R0.isClickable()) {
                this.R0.setClickable(true);
                this.R0.setTextColor(this.U0.getPublishTextColor());
            } else if (z || !this.R0.isClickable()) {
            } else {
                this.R0.setClickable(false);
                this.R0.setTextColor(getResources().getColor(c.a.r0.a.c.swanapp_ugc_publish_no_able_color));
            }
        }
    }

    public void k3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            c.a.r0.a.z1.j.e.k(this.L0);
            this.L0.removeListener();
            this.K0.removeListener();
            p3();
        }
    }

    public final void l3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.N0.setImageResource(c.a.r0.a.e.swanapp_ugc_switch_soft_emoji_pressed);
            this.N0.setClickable(false);
        }
    }

    public final void m3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.P0.setImageResource(c.a.r0.a.e.swanapp_ugc_choose_photo_pressed);
            this.P0.setClickable(false);
        }
    }

    public final void n3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.N0.setImageResource(c.a.r0.a.e.swanapp_ugc_switch_soft_emoji_selector);
            this.N0.setClickable(true);
        }
    }

    public final void o3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.P0.setImageResource(c.a.r0.a.e.swanapp_publisher_photo_choose_selector);
            this.P0.setClickable(true);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, view) == null) {
            int id = view.getId();
            if (id == c.a.r0.a.f.publish_button) {
                c.a.r0.a.z1.j.c.onEvent("pub_clk");
                r3();
            } else if (id == c.a.r0.a.f.cancel_button) {
                c.a.r0.a.z1.j.c.onEvent("cancel_clk");
                w3();
            } else if (id == c.a.r0.a.f.add_picture) {
                c.a.r0.a.z1.j.c.onEvent("pic_clk_bar");
                c.a.r0.a.z1.j.g.i(this.O0.getLeftCount(), this);
            } else if (id == c.a.r0.a.f.clear_title) {
                this.K0.setText("");
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bundle) == null) {
            super.onCreate(bundle);
            Bundle t = t();
            if (t != null) {
                PublishParams publishParams = (PublishParams) t.getParcelable("params");
                this.U0 = publishParams;
                if (publishParams == null) {
                    this.V0 = true;
                    return;
                }
                return;
            }
            this.V0 = true;
        }
    }

    @Override // c.a.r0.a.z1.j.e.b
    public void onSoftInputShowing(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            if (e1) {
                String str = "soft input is showing ? " + z;
            }
            this.Y0 = z;
        }
    }

    public final void p3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            g.b i2 = c.a.r0.a.g1.f.U().V().i("navigateBack");
            i2.n(c.a.r0.a.h0.g.g.f6401i, c.a.r0.a.h0.g.g.f6400h);
            i2.g();
            i2.a();
        }
    }

    public final List<String> q3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (this.U0.supportImage().booleanValue()) {
                return this.O0.getData();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    public final void r3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            boolean z = e1;
            if (!SwanAppNetworkUtils.i(getContext())) {
                c.a.r0.a.z1.j.g.h(getContext(), c.a.r0.a.h.swanapp_publisher_image_upload_fail);
            } else if (this.X0 == null) {
            } else {
                String obj = this.K0.getText().toString();
                String obj2 = this.L0.getText().toString();
                List<String> q3 = q3();
                if (this.U0.supportTitle().booleanValue() && TextUtils.isEmpty(obj.trim())) {
                    c.a.r0.a.z1.j.g.h(getContext(), c.a.r0.a.h.swanapp_publisher_error_empty);
                } else if (TextUtils.isEmpty(obj2.trim()) && (q3 == null || q3.size() == 0)) {
                    c.a.r0.a.z1.j.g.h(getContext(), c.a.r0.a.h.swanapp_publisher_error_empty);
                } else if (q3 != null && q3.size() > 0) {
                    ViewGroup viewGroup = (ViewGroup) getActivity().findViewById(16908290);
                    c.a.r0.a.c2.b.d.a.h(getContext(), viewGroup, getResources().getString(c.a.r0.a.h.swanapp_publisher_handling_pictures));
                    this.R0.setClickable(false);
                    this.R0.setTextColor(getResources().getColor(c.a.r0.a.c.swanapp_ugc_publish_no_able_color));
                    q.f().execute(new l(this, q3, obj, obj2, viewGroup));
                } else {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (!obj.isEmpty()) {
                            jSONObject.put("title", this.K0.getText().toString());
                        }
                        if (!obj2.isEmpty()) {
                            jSONObject.put("content", this.L0.getText().toString());
                        }
                        if (e1) {
                            String str = "publish result " + jSONObject.toString();
                        }
                        c.a.r0.a.z1.g.a.a();
                        this.X0.a(jSONObject);
                    } catch (JSONException e2) {
                        if (e1) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public final void s3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            DraftData c2 = c.a.r0.a.z1.g.a.c();
            this.W0 = c2;
            if (c2 != null) {
                boolean z = e1;
                String title = this.W0.getTitle();
                if (this.U0.supportTitle().booleanValue() && !TextUtils.isEmpty(title)) {
                    this.K0.setText(title);
                    this.K0.setSelection(title.length());
                    this.T0 = this.K0;
                }
                String content = this.W0.getContent();
                if (!TextUtils.isEmpty(content)) {
                    this.L0.setText(content);
                    if (this.U0.supportEmoji().booleanValue() && c.a.r0.a.z1.h.b.c().e()) {
                        this.L0.handleDraftEmojiDisplay();
                    }
                    EmojiEditText emojiEditText = this.L0;
                    emojiEditText.setSelection(emojiEditText.getText().length());
                    this.T0 = this.L0;
                }
                if (this.U0.supportImage().booleanValue()) {
                    this.O0.update(this.W0.getImages());
                    if (this.O0.getLeftCount() == 0) {
                        m3();
                        return;
                    }
                    return;
                }
                return;
            }
            this.W0 = new DraftData(0L, "", "", null);
        }
    }

    public final void t3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            c.a.r0.a.z1.j.e.c(getActivity(), (ViewGroup) getActivity().findViewById(16908290), this.J0, this);
            c.a.r0.a.z1.j.b.b(this.J0, this.N0, this.L0, new e(this));
            c.a.r0.a.z1.h.d.b().c(getActivity(), this.J0, this.L0, this.U0.getEmojiPath(), this.U0.getAppId(), this.U0.getAppVersion());
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void u3(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, view) == null) {
            boolean z = e1;
            this.K0 = (EmojiEditText) view.findViewById(c.a.r0.a.f.post_title);
            if (this.U0.supportTitle().booleanValue()) {
                view.findViewById(c.a.r0.a.f.post_title_layout).setVisibility(0);
                this.K0.setHint(this.U0.getTitleHint());
                this.K0.setListener(this.c1);
                this.K0.setMaxSize(20);
                this.K0.setOnFocusChangeListener(new f(this));
            } else {
                view.findViewById(c.a.r0.a.f.post_title_layout).setVisibility(8);
            }
            this.N0 = (ImageView) view.findViewById(c.a.r0.a.f.add_emoij);
            if (this.U0.supportEmoji().booleanValue() && !TextUtils.isEmpty(this.U0.getEmojiPath().trim())) {
                this.N0.setVisibility(0);
            } else {
                this.N0.setVisibility(8);
            }
            this.J0 = (SPSwitchPanelLinearLayout) view.findViewById(c.a.r0.a.f.emoji_panel_root);
            view.findViewById(c.a.r0.a.f.nav_bar).setBackgroundColor(this.U0.getNavBarBgColor());
            TextView textView = (TextView) view.findViewById(c.a.r0.a.f.publish_title);
            textView.setText(this.U0.getNavBarTitle());
            textView.setTextColor(this.U0.getNavBarTextColor());
            ImageView imageView = (ImageView) view.findViewById(c.a.r0.a.f.clear_title);
            this.S0 = imageView;
            imageView.setOnClickListener(this);
            this.M0 = (TextView) view.findViewById(c.a.r0.a.f.post_target);
            if (this.U0.supportTarget().booleanValue() && !TextUtils.isEmpty(this.U0.getTarget().trim())) {
                TextView textView2 = this.M0;
                textView2.setText("发布到 " + this.U0.getTarget());
            } else {
                view.findViewById(c.a.r0.a.f.post_target_layout).setVisibility(8);
            }
            this.Q0 = (TextView) view.findViewById(c.a.r0.a.f.text_number);
            EmojiEditText emojiEditText = (EmojiEditText) view.findViewById(c.a.r0.a.f.post_content);
            this.L0 = emojiEditText;
            emojiEditText.setOnKeyListener(new g(this));
            this.L0.setHint(this.U0.getContentHint());
            this.L0.setListener(this.d1);
            this.L0.setMaxSize(4999);
            this.L0.setOnFocusChangeListener(new h(this));
            view.findViewById(c.a.r0.a.f.content_scroll_layout).setOnTouchListener(new i(this));
            TextView textView3 = (TextView) view.findViewById(c.a.r0.a.f.publish_button);
            this.R0 = textView3;
            textView3.setText(this.U0.getPublishText());
            this.R0.setOnClickListener(this);
            this.R0.setClickable(false);
            TextView textView4 = (TextView) view.findViewById(c.a.r0.a.f.cancel_button);
            textView4.setText(this.U0.getCancelText());
            textView4.setTextColor(this.U0.getCancelTextColor());
            textView4.setOnClickListener(this);
            textView4.setOnTouchListener(new j(this));
            this.P0 = (ImageView) view.findViewById(c.a.r0.a.f.add_picture);
            this.O0 = (PhotoChooseView) view.findViewById(c.a.r0.a.f.pic_choose);
            if (this.U0.supportImage().booleanValue()) {
                this.P0.setVisibility(0);
                this.P0.setOnClickListener(this);
                this.O0.setVisibility(0);
                this.O0.init(getActivity());
                this.O0.setMaxCount(this.U0.getMaxImageNum());
                this.O0.setCallback(this);
                this.O0.setDeleteListener(new k(this));
            } else {
                this.P0.setVisibility(8);
                this.O0.setVisibility(8);
            }
            this.b1 = getResources().getColor(c.a.r0.a.c.swanapp_text_number_color);
        }
    }

    public final boolean v3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            String trim = this.U0.supportTitle().booleanValue() ? this.K0.getText().toString().trim() : "";
            String trim2 = this.L0.getText().toString().trim();
            List<String> q3 = q3();
            if (TextUtils.isEmpty(trim) && TextUtils.isEmpty(trim2) && q3 == null) {
                c.a.r0.a.z1.g.a.a();
                return false;
            }
            if (TextUtils.equals(trim, this.W0.getTitle()) && TextUtils.equals(trim2, this.W0.getContent())) {
                List<String> images = this.W0.getImages();
                if (images == null && q3 == null) {
                    return false;
                }
                if (images != null && q3 != null && images.size() == q3.size()) {
                    for (int i2 = 0; i2 < q3.size(); i2++) {
                        if (!TextUtils.equals(images.get(i2), q3.get(i2))) {
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
    public View w0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048602, this, layoutInflater, viewGroup, bundle)) == null) {
            super.w0(layoutInflater, viewGroup, bundle);
            return layoutInflater.inflate(c.a.r0.a.g.swanapp_publisher_layout, viewGroup, false);
        }
        return (View) invokeLLL.objValue;
    }

    public final void w3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            if (v3()) {
                A3();
                return;
            }
            k3();
            c.a.r0.a.z1.a aVar = this.X0;
            if (aVar != null) {
                aVar.onCancel();
            }
        }
    }

    public void x3(c.a.r0.a.z1.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, aVar) == null) {
            this.X0 = aVar;
        }
    }

    public final void y3(View view, MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048605, this, view, motionEvent) == null) {
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

    public final void z3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            SwanAppAlertDialog.a aVar = new SwanAppAlertDialog.a(getContext());
            aVar.m(false);
            aVar.U(c.a.r0.a.h.swanapp_publisher_error_title);
            aVar.v(c.a.r0.a.h.swanapp_publisher_params_error);
            aVar.O(c.a.r0.a.h.aiapps_confirm, new b(this));
            aVar.X();
        }
    }
}

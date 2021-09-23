package c.a.p0.a.w1;

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
import c.a.p0.a.h0.g.g;
import c.a.p0.a.v2.q;
import c.a.p0.a.w1.j.b;
import c.a.p0.a.w1.j.e;
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
public class c extends c.a.p0.a.h0.g.d implements View.OnClickListener, c.a.p0.a.i1.d.d.c<MediaModel>, e.b {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean X0;
    public transient /* synthetic */ FieldHolder $fh;
    public SPSwitchPanelLinearLayout C0;
    public EmojiEditText D0;
    public EmojiEditText E0;
    public TextView F0;
    public ImageView G0;
    public PhotoChooseView H0;
    public ImageView I0;
    public TextView J0;
    public TextView K0;
    public ImageView L0;
    public View M0;
    public PublishParams N0;
    public boolean O0;
    public DraftData P0;
    public c.a.p0.a.w1.a Q0;
    public boolean R0;
    public int S0;
    public int T0;
    public int U0;
    public EmojiEditText.e V0;
    public EmojiEditText.e W0;

    /* loaded from: classes.dex */
    public class a implements EmojiEditText.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f9472a;

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
            this.f9472a = cVar;
        }

        @Override // com.baidu.swan.apps.publisher.emoji.EmojiEditText.e
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f9472a.T0 = i2;
                int i3 = i2 - 4999;
                this.f9472a.J0.setVisibility(0);
                if (i3 < 999) {
                    this.f9472a.J0.setText(String.format("超%d字", Integer.valueOf(i3)));
                } else {
                    this.f9472a.J0.setText("超999+");
                }
                this.f9472a.J0.setTextColor(SupportMenu.CATEGORY_MASK);
                this.f9472a.a3();
            }
        }

        @Override // com.baidu.swan.apps.publisher.emoji.EmojiEditText.e
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                this.f9472a.T0 = i2;
                if (i2 <= 4979) {
                    this.f9472a.J0.setVisibility(8);
                } else {
                    this.f9472a.J0.setText(String.format("剩%d字", Integer.valueOf(4999 - i2)));
                    this.f9472a.J0.setVisibility(0);
                    this.f9472a.J0.setTextColor(this.f9472a.U0);
                }
                this.f9472a.a3();
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
        public final /* synthetic */ c f9473e;

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
            this.f9473e = cVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                this.f9473e.g3();
            }
        }
    }

    /* renamed from: c.a.p0.a.w1.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class DialogInterface$OnClickListenerC0442c implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f9474e;

        public DialogInterface$OnClickListenerC0442c(c cVar) {
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
            this.f9474e = cVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                c.a.p0.a.w1.j.c.onEvent("draft_save");
                this.f9474e.P0.setTimeStamp(System.currentTimeMillis());
                this.f9474e.P0.setTitle(this.f9474e.D0.getText().toString());
                this.f9474e.P0.setContent(this.f9474e.E0.getText().toString());
                this.f9474e.P0.setImages(this.f9474e.h3());
                c.a.p0.a.w1.g.a.d(this.f9474e.P0);
                this.f9474e.b3();
                if (this.f9474e.Q0 != null) {
                    this.f9474e.Q0.onCancel();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f9475e;

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
            this.f9475e = cVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                c.a.p0.a.w1.j.c.onEvent("draft_quit");
                c.a.p0.a.w1.g.a.a();
                this.f9475e.b3();
                if (this.f9475e.Q0 != null) {
                    this.f9475e.Q0.onCancel();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f9476a;

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
            this.f9476a = cVar;
        }

        @Override // c.a.p0.a.w1.j.b.c
        public void onClickSwitch(View view, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view, z) == null) {
                this.f9476a.Y2(z);
                c.a.p0.a.w1.j.c.onEvent("emoji_clk");
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f9477e;

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
            this.f9477e = cVar;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, view, z) == null) && z) {
                this.f9477e.c3();
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements View.OnKeyListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f9478e;

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
            this.f9478e = cVar;
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
        public final /* synthetic */ c f9479e;

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
            this.f9479e = cVar;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, view, z) == null) && z) {
                this.f9479e.e3();
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f9480e;

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
            this.f9480e = cVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (motionEvent.getAction() == 1) {
                    this.f9480e.Z2();
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
        public final /* synthetic */ c f9481e;

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
            this.f9481e = cVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                this.f9481e.p3(view, motionEvent);
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
        public final /* synthetic */ c f9482a;

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
            this.f9482a = cVar;
        }

        @Override // com.baidu.swan.apps.publisher.view.PhotoChooseView.b
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 == 0) {
                    this.f9482a.a3();
                }
                if (i2 == this.f9482a.N0.getMaxImageNum() - 1) {
                    this.f9482a.f3();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f9483e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f9484f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f9485g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f9486h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c f9487i;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ l f9488e;

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
                this.f9488e = lVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.p0.a.z1.b.d.a.c(this.f9488e.f9486h);
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
            this.f9487i = cVar;
            this.f9483e = list;
            this.f9484f = str;
            this.f9485g = str2;
            this.f9486h = viewGroup;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONObject a2 = c.a.p0.a.w1.j.a.a(this.f9483e, this.f9487i.N0.getImageRatio());
                    if (a2 == null) {
                        boolean z = c.X0;
                        a2 = new JSONObject();
                    }
                    if (!this.f9484f.isEmpty()) {
                        a2.put("title", this.f9487i.D0.getText().toString());
                    }
                    if (!this.f9485g.isEmpty()) {
                        a2.put("content", this.f9487i.E0.getText().toString());
                    }
                    if (c.X0) {
                        String str = "publish result " + a2.toString();
                    }
                    this.f9486h.post(new a(this));
                    c.a.p0.a.w1.g.a.a();
                    this.f9487i.Q0.a(a2);
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
        public final /* synthetic */ c f9489a;

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
            this.f9489a = cVar;
        }

        @Override // com.baidu.swan.apps.publisher.emoji.EmojiEditText.e
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f9489a.S0 = i2;
                this.f9489a.D0.setText(this.f9489a.D0.getText().toString().substring(0, 20));
                this.f9489a.D0.setSelection(20);
                c.a.p0.a.w1.j.g.h(this.f9489a.q(), c.a.p0.a.h.swanapp_publisher_title_exceed);
                this.f9489a.a3();
            }
        }

        @Override // com.baidu.swan.apps.publisher.emoji.EmojiEditText.e
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                this.f9489a.S0 = i2;
                if (i2 == 0) {
                    this.f9489a.L0.setVisibility(8);
                } else {
                    this.f9489a.L0.setVisibility(0);
                }
                this.f9489a.a3();
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(832889654, "Lc/a/p0/a/w1/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(832889654, "Lc/a/p0/a/w1/c;");
                return;
            }
        }
        X0 = c.a.p0.a.k.f7085a;
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
        this.O0 = false;
        this.R0 = false;
        this.S0 = 0;
        this.T0 = 0;
        this.V0 = new m(this);
        this.W0 = new a(this);
    }

    @Override // c.a.p0.a.h0.g.d
    public boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.R0) {
                boolean z = X0;
                c.a.p0.a.w1.j.e.k(this.E0);
                this.R0 = false;
                return true;
            } else if (m3()) {
                boolean z2 = X0;
                r3();
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
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, bundle) == null) {
            super.L0(view, bundle);
            if (this.O0) {
                q3();
                return;
            }
            l3(view);
            if (this.N0.supportEmoji().booleanValue() && !TextUtils.isEmpty(this.N0.getEmojiPath().trim())) {
                k3();
            }
            j3();
            if (this.M0 == null) {
                this.M0 = this.N0.supportTitle().booleanValue() ? this.D0 : this.E0;
            }
            c.a.p0.a.w1.j.e.n(this.M0, 300L);
            c.a.p0.a.w1.j.c.onEvent("show");
            a3();
        }
    }

    @Override // c.a.p0.a.h0.g.d
    public boolean V1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.a.h0.g.d
    public boolean X1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void Y2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            if (z) {
                this.G0.setImageResource(c.a.p0.a.e.swanapp_ugc_keyboard_selector);
            } else {
                this.G0.setImageResource(c.a.p0.a.e.swanapp_ugc_switch_soft_emoji_selector);
            }
        }
    }

    public final void Z2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c.a.p0.a.w1.j.b.d(this.C0, this.E0);
            ImageView imageView = this.G0;
            if (imageView != null) {
                imageView.setImageResource(c.a.p0.a.e.swanapp_ugc_switch_soft_emoji_selector);
            }
        }
    }

    public final void a3() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            List<String> h3 = h3();
            boolean z = !this.N0.supportTitle().booleanValue() ? ((i2 = this.T0) <= 0 || i2 > 4999) && (h3 == null || h3.size() <= 0) : this.S0 <= 0 || (this.T0 <= 0 && (h3 == null || h3.size() <= 0));
            if (z && !this.K0.isClickable()) {
                this.K0.setClickable(true);
                this.K0.setTextColor(this.N0.getPublishTextColor());
            } else if (z || !this.K0.isClickable()) {
            } else {
                this.K0.setClickable(false);
                this.K0.setTextColor(z().getColor(c.a.p0.a.c.swanapp_ugc_publish_no_able_color));
            }
        }
    }

    public void b3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c.a.p0.a.w1.j.e.k(this.E0);
            this.E0.removeListener();
            this.D0.removeListener();
            g3();
        }
    }

    @Override // c.a.p0.a.h0.g.d
    public void c2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    public final void c3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.G0.setImageResource(c.a.p0.a.e.swanapp_ugc_switch_soft_emoji_pressed);
            this.G0.setClickable(false);
        }
    }

    @Override // c.a.p0.a.i1.d.d.c
    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
        }
    }

    public final void d3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.I0.setImageResource(c.a.p0.a.e.swanapp_ugc_choose_photo_pressed);
            this.I0.setClickable(false);
        }
    }

    public final void e3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.G0.setImageResource(c.a.p0.a.e.swanapp_ugc_switch_soft_emoji_selector);
            this.G0.setClickable(true);
        }
    }

    @Override // c.a.p0.a.i1.d.d.c
    public void f(List<MediaModel> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, list) == null) {
            ArrayList arrayList = new ArrayList();
            for (MediaModel mediaModel : list) {
                arrayList.add(mediaModel.getPath());
            }
            this.H0.update(arrayList);
            if (this.N0.supportTitle().booleanValue() && this.S0 == 0 && this.T0 == 0) {
                c.a.p0.a.w1.j.e.n(this.D0, 300L);
            } else {
                c.a.p0.a.w1.j.e.n(this.E0, 300L);
            }
            a3();
            if (this.H0.getLeftCount() == 0) {
                d3();
            }
        }
    }

    public final void f3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.I0.setImageResource(c.a.p0.a.e.swanapp_publisher_photo_choose_selector);
            this.I0.setClickable(true);
        }
    }

    public final void g3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            g.b i2 = c.a.p0.a.g1.f.V().W().i("navigateBack");
            i2.n(c.a.p0.a.h0.g.g.f5938i, c.a.p0.a.h0.g.g.f5937h);
            i2.g();
            i2.a();
        }
    }

    public final List<String> h3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (this.N0.supportImage().booleanValue()) {
                return this.H0.getData();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    public final void i3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            boolean z = X0;
            if (!SwanAppNetworkUtils.i(q())) {
                c.a.p0.a.w1.j.g.h(q(), c.a.p0.a.h.swanapp_publisher_image_upload_fail);
            } else if (this.Q0 == null) {
            } else {
                String obj = this.D0.getText().toString();
                String obj2 = this.E0.getText().toString();
                List<String> h3 = h3();
                if (this.N0.supportTitle().booleanValue() && TextUtils.isEmpty(obj.trim())) {
                    c.a.p0.a.w1.j.g.h(q(), c.a.p0.a.h.swanapp_publisher_error_empty);
                } else if (TextUtils.isEmpty(obj2.trim()) && (h3 == null || h3.size() == 0)) {
                    c.a.p0.a.w1.j.g.h(q(), c.a.p0.a.h.swanapp_publisher_error_empty);
                } else if (h3 != null && h3.size() > 0) {
                    ViewGroup viewGroup = (ViewGroup) h().findViewById(16908290);
                    c.a.p0.a.z1.b.d.a.f(q(), viewGroup, z().getString(c.a.p0.a.h.swanapp_publisher_handling_pictures));
                    this.K0.setClickable(false);
                    this.K0.setTextColor(z().getColor(c.a.p0.a.c.swanapp_ugc_publish_no_able_color));
                    q.e().execute(new l(this, h3, obj, obj2, viewGroup));
                } else {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (!obj.isEmpty()) {
                            jSONObject.put("title", this.D0.getText().toString());
                        }
                        if (!obj2.isEmpty()) {
                            jSONObject.put("content", this.E0.getText().toString());
                        }
                        if (X0) {
                            String str = "publish result " + jSONObject.toString();
                        }
                        c.a.p0.a.w1.g.a.a();
                        this.Q0.a(jSONObject);
                    } catch (JSONException e2) {
                        if (X0) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public final void j3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            DraftData c2 = c.a.p0.a.w1.g.a.c();
            this.P0 = c2;
            if (c2 != null) {
                boolean z = X0;
                String title = this.P0.getTitle();
                if (this.N0.supportTitle().booleanValue() && !TextUtils.isEmpty(title)) {
                    this.D0.setText(title);
                    this.D0.setSelection(title.length());
                    this.M0 = this.D0;
                }
                String content = this.P0.getContent();
                if (!TextUtils.isEmpty(content)) {
                    this.E0.setText(content);
                    if (this.N0.supportEmoji().booleanValue() && c.a.p0.a.w1.h.b.c().e()) {
                        this.E0.handleDraftEmojiDisplay();
                    }
                    EmojiEditText emojiEditText = this.E0;
                    emojiEditText.setSelection(emojiEditText.getText().length());
                    this.M0 = this.E0;
                }
                if (this.N0.supportImage().booleanValue()) {
                    this.H0.update(this.P0.getImages());
                    if (this.H0.getLeftCount() == 0) {
                        d3();
                        return;
                    }
                    return;
                }
                return;
            }
            this.P0 = new DraftData(0L, "", "", null);
        }
    }

    public final void k3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            c.a.p0.a.w1.j.e.c(h(), (ViewGroup) h().findViewById(16908290), this.C0, this);
            c.a.p0.a.w1.j.b.b(this.C0, this.G0, this.E0, new e(this));
            c.a.p0.a.w1.h.d.b().c(h(), this.C0, this.E0, this.N0.getEmojiPath(), this.N0.getAppId(), this.N0.getAppVersion());
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void l3(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, view) == null) {
            boolean z = X0;
            this.D0 = (EmojiEditText) view.findViewById(c.a.p0.a.f.post_title);
            if (this.N0.supportTitle().booleanValue()) {
                view.findViewById(c.a.p0.a.f.post_title_layout).setVisibility(0);
                this.D0.setHint(this.N0.getTitleHint());
                this.D0.setListener(this.V0);
                this.D0.setMaxSize(20);
                this.D0.setOnFocusChangeListener(new f(this));
            } else {
                view.findViewById(c.a.p0.a.f.post_title_layout).setVisibility(8);
            }
            this.G0 = (ImageView) view.findViewById(c.a.p0.a.f.add_emoij);
            if (this.N0.supportEmoji().booleanValue() && !TextUtils.isEmpty(this.N0.getEmojiPath().trim())) {
                this.G0.setVisibility(0);
            } else {
                this.G0.setVisibility(8);
            }
            this.C0 = (SPSwitchPanelLinearLayout) view.findViewById(c.a.p0.a.f.emoji_panel_root);
            view.findViewById(c.a.p0.a.f.nav_bar).setBackgroundColor(this.N0.getNavBarBgColor());
            TextView textView = (TextView) view.findViewById(c.a.p0.a.f.publish_title);
            textView.setText(this.N0.getNavBarTitle());
            textView.setTextColor(this.N0.getNavBarTextColor());
            ImageView imageView = (ImageView) view.findViewById(c.a.p0.a.f.clear_title);
            this.L0 = imageView;
            imageView.setOnClickListener(this);
            this.F0 = (TextView) view.findViewById(c.a.p0.a.f.post_target);
            if (this.N0.supportTarget().booleanValue() && !TextUtils.isEmpty(this.N0.getTarget().trim())) {
                TextView textView2 = this.F0;
                textView2.setText("发布到 " + this.N0.getTarget());
            } else {
                view.findViewById(c.a.p0.a.f.post_target_layout).setVisibility(8);
            }
            this.J0 = (TextView) view.findViewById(c.a.p0.a.f.text_number);
            EmojiEditText emojiEditText = (EmojiEditText) view.findViewById(c.a.p0.a.f.post_content);
            this.E0 = emojiEditText;
            emojiEditText.setOnKeyListener(new g(this));
            this.E0.setHint(this.N0.getContentHint());
            this.E0.setListener(this.W0);
            this.E0.setMaxSize(4999);
            this.E0.setOnFocusChangeListener(new h(this));
            view.findViewById(c.a.p0.a.f.content_scroll_layout).setOnTouchListener(new i(this));
            TextView textView3 = (TextView) view.findViewById(c.a.p0.a.f.publish_button);
            this.K0 = textView3;
            textView3.setText(this.N0.getPublishText());
            this.K0.setOnClickListener(this);
            this.K0.setClickable(false);
            TextView textView4 = (TextView) view.findViewById(c.a.p0.a.f.cancel_button);
            textView4.setText(this.N0.getCancelText());
            textView4.setTextColor(this.N0.getCancelTextColor());
            textView4.setOnClickListener(this);
            textView4.setOnTouchListener(new j(this));
            this.I0 = (ImageView) view.findViewById(c.a.p0.a.f.add_picture);
            this.H0 = (PhotoChooseView) view.findViewById(c.a.p0.a.f.pic_choose);
            if (this.N0.supportImage().booleanValue()) {
                this.I0.setVisibility(0);
                this.I0.setOnClickListener(this);
                this.H0.setVisibility(0);
                this.H0.init(h());
                this.H0.setMaxCount(this.N0.getMaxImageNum());
                this.H0.setCallback(this);
                this.H0.setDeleteListener(new k(this));
            } else {
                this.I0.setVisibility(8);
                this.H0.setVisibility(8);
            }
            this.U0 = z().getColor(c.a.p0.a.c.swanapp_text_number_color);
        }
    }

    public final boolean m3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            String trim = this.N0.supportTitle().booleanValue() ? this.D0.getText().toString().trim() : "";
            String trim2 = this.E0.getText().toString().trim();
            List<String> h3 = h3();
            if (TextUtils.isEmpty(trim) && TextUtils.isEmpty(trim2) && h3 == null) {
                c.a.p0.a.w1.g.a.a();
                return false;
            }
            if (TextUtils.equals(trim, this.P0.getTitle()) && TextUtils.equals(trim2, this.P0.getContent())) {
                List<String> images = this.P0.getImages();
                if (images == null && h3 == null) {
                    return false;
                }
                if (images != null && h3 != null && images.size() == h3.size()) {
                    for (int i2 = 0; i2 < h3.size(); i2++) {
                        if (!TextUtils.equals(images.get(i2), h3.get(i2))) {
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

    public final void n3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            if (m3()) {
                r3();
                return;
            }
            b3();
            c.a.p0.a.w1.a aVar = this.Q0;
            if (aVar != null) {
                aVar.onCancel();
            }
        }
    }

    public void o3(c.a.p0.a.w1.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, aVar) == null) {
            this.Q0 = aVar;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, view) == null) {
            int id = view.getId();
            if (id == c.a.p0.a.f.publish_button) {
                c.a.p0.a.w1.j.c.onEvent("pub_clk");
                i3();
            } else if (id == c.a.p0.a.f.cancel_button) {
                c.a.p0.a.w1.j.c.onEvent("cancel_clk");
                n3();
            } else if (id == c.a.p0.a.f.add_picture) {
                c.a.p0.a.w1.j.c.onEvent("pic_clk_bar");
                c.a.p0.a.w1.j.g.i(this.H0.getLeftCount(), this);
            } else if (id == c.a.p0.a.f.clear_title) {
                this.D0.setText("");
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, bundle) == null) {
            super.onCreate(bundle);
            Bundle o = o();
            if (o != null) {
                PublishParams publishParams = (PublishParams) o.getParcelable("params");
                this.N0 = publishParams;
                if (publishParams == null) {
                    this.O0 = true;
                    return;
                }
                return;
            }
            this.O0 = true;
        }
    }

    @Override // c.a.p0.a.w1.j.e.b
    public void onSoftInputShowing(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            if (X0) {
                String str = "soft input is showing ? " + z;
            }
            this.R0 = z;
        }
    }

    public final void p3(View view, MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048603, this, view, motionEvent) == null) {
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

    public final void q3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            SwanAppAlertDialog.a aVar = new SwanAppAlertDialog.a(q());
            aVar.m(false);
            aVar.U(c.a.p0.a.h.swanapp_publisher_error_title);
            aVar.v(c.a.p0.a.h.swanapp_publisher_params_error);
            aVar.O(c.a.p0.a.h.aiapps_confirm, new b(this));
            aVar.X();
        }
    }

    public final void r3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            SwanAppAlertDialog.a aVar = new SwanAppAlertDialog.a(h());
            aVar.U(c.a.p0.a.h.swanapp_save_draft_dialog_title);
            aVar.B(c.a.p0.a.h.swanapp_save_draft_dialog_btn_negative, new d(this));
            aVar.v(c.a.p0.a.h.swanapp_save_draft_dialog_message);
            aVar.O(c.a.p0.a.h.swanapp_save_draft_dialog_btn_positive, new DialogInterface$OnClickListenerC0442c(this));
            aVar.X();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View z0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048606, this, layoutInflater, viewGroup, bundle)) == null) {
            super.z0(layoutInflater, viewGroup, bundle);
            return layoutInflater.inflate(c.a.p0.a.g.swanapp_publisher_layout, viewGroup, false);
        }
        return (View) invokeLLL.objValue;
    }
}

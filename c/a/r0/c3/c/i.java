package c.a.r0.c3.c;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import c.a.e.e.p.k;
import c.a.e.e.p.l;
import c.a.q0.s.s.a;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class i extends c.a.q0.s.s.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public LinearLayout f16267a;

    /* renamed from: b  reason: collision with root package name */
    public EditText f16268b;

    /* loaded from: classes3.dex */
    public class a implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f16269e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ i f16270f;

        public a(i iVar, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16270f = iVar;
            this.f16269e = activity;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (!k.isEmpty(this.f16270f.f16268b.getText().toString())) {
                    TbSingleton.getInstance().setVisitPreviewServer(true);
                    String obj = this.f16270f.f16268b.getText().toString();
                    TbSingleton.getInstance().setPubEnvValue(obj);
                    l.L(this.f16269e, R.string.change_success);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921508, obj));
                }
                this.f16270f.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f16271e;

        public b(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16271e = iVar;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f16271e.dismiss();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(Activity activity) {
        super(activity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Activity) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(R.layout.dialog_visit_preview_server, (ViewGroup) null);
        this.f16267a = linearLayout;
        setContentView(linearLayout);
        this.f16268b = (EditText) this.f16267a.findViewById(R.id.et_visit_preview_server_dialog_pub_env_value);
        setPositiveButton(R.string.confirm, new a(this, activity));
        setNegativeButton(R.string.cancel, new b(this));
    }
}

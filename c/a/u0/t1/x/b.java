package c.a.u0.t1.x;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import c.a.d.a.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.ValidateItemData;
import com.baidu.tieba.im.validate.ValidateActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class b extends c.a.d.a.c<ValidateActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public View f22769b;

    /* renamed from: c  reason: collision with root package name */
    public HeadImageView f22770c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f22771d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f22772e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f22773f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f22774g;

    /* renamed from: h  reason: collision with root package name */
    public ValidateActivity f22775h;

    /* renamed from: i  reason: collision with root package name */
    public ValidateItemData f22776i;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f22777e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22777e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f22777e.f22775h.onItemViewClick(this.f22777e.f22774g, 100, 0, 0L, this.f22777e.f22776i);
            }
        }
    }

    /* renamed from: c.a.u0.t1.x.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class View$OnClickListenerC1399b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f22778e;

        public View$OnClickListenerC1399b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22778e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f22778e.f22775h.onItemViewClick(this.f22778e.f22770c, 101, 0, 0L, this.f22778e.f22776i);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f22779e;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22779e = bVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                this.f22779e.f22775h.onItemViewLongClick(this.f22779e.f22769b, 200, 0, 0L, this.f22779e.f22776i);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext(), R.layout.validate_item);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {validateActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((f) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f22775h = validateActivity;
        j();
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View findViewById = this.a.findViewById(R.id.root_view);
            this.f22769b = findViewById;
            HeadImageView headImageView = (HeadImageView) findViewById.findViewById(R.id.iv_head);
            this.f22770c = headImageView;
            headImageView.setIsRound(false);
            this.f22771d = (TextView) this.f22769b.findViewById(R.id.tv_user_name);
            this.f22772e = (TextView) this.f22769b.findViewById(R.id.tv_group_name);
            this.f22773f = (TextView) this.f22769b.findViewById(R.id.tv_apply_reason);
            TextView textView = (TextView) this.f22769b.findViewById(R.id.btn_pass);
            this.f22774g = textView;
            textView.setOnClickListener(new a(this));
            this.f22770c.setOnClickListener(new View$OnClickListenerC1399b(this));
            this.f22769b.setOnLongClickListener(new c(this));
        }
    }

    public void k(ValidateItemData validateItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, validateItemData) == null) {
            l(validateItemData);
            refresh();
        }
    }

    public void l(ValidateItemData validateItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, validateItemData) == null) {
            this.f22776i = validateItemData;
        }
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f22776i == null) {
            return;
        }
        this.f22775h.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
        this.f22775h.getLayoutMode().j(this.f22769b);
        String portrait = this.f22776i.getPortrait();
        this.f22770c.setTag(portrait);
        this.f22770c.startLoad(portrait, 12, false);
        if (!TextUtils.isEmpty(this.f22776i.getUserName())) {
            this.f22771d.setText(this.f22776i.getUserName());
        }
        if (!TextUtils.isEmpty(this.f22776i.getGroupName())) {
            TextView textView = this.f22772e;
            textView.setText(this.f22775h.getPageContext().getString(R.string.validate_im_apply_prefix) + this.f22776i.getGroupName());
        }
        if (!TextUtils.isEmpty(this.f22776i.getApplyReason())) {
            TextView textView2 = this.f22773f;
            textView2.setText(this.f22775h.getPageContext().getString(R.string.validate_im_reason_prefix) + this.f22776i.getApplyReason());
        }
        if (this.f22776i.isPass()) {
            this.f22774g.setEnabled(false);
            this.f22774g.setText(this.f22775h.getPageContext().getString(R.string.passed));
            SkinManager.setViewTextColor(this.f22774g, R.color.CAM_X0109);
            this.f22774g.setBackgroundDrawable(null);
        } else {
            this.f22774g.setEnabled(true);
            this.f22774g.setText(this.f22775h.getPageContext().getString(R.string.pass));
        }
        if (this.f22776i.isShown()) {
            return;
        }
        SkinManager.setBackgroundResource(this.f22769b, R.color.common_color_10178);
    }
}

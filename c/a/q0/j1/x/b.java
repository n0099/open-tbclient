package c.a.q0.j1.x;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import c.a.e.a.f;
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
/* loaded from: classes3.dex */
public class b extends c.a.e.a.c<ValidateActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public View f21090b;

    /* renamed from: c  reason: collision with root package name */
    public HeadImageView f21091c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f21092d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f21093e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f21094f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f21095g;

    /* renamed from: h  reason: collision with root package name */
    public ValidateActivity f21096h;

    /* renamed from: i  reason: collision with root package name */
    public ValidateItemData f21097i;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f21098e;

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
            this.f21098e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f21098e.f21096h.onItemViewClick(this.f21098e.f21095g, 100, 0, 0L, this.f21098e.f21097i);
            }
        }
    }

    /* renamed from: c.a.q0.j1.x.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC0982b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f21099e;

        public View$OnClickListenerC0982b(b bVar) {
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
            this.f21099e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f21099e.f21096h.onItemViewClick(this.f21099e.f21091c, 101, 0, 0L, this.f21099e.f21097i);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f21100e;

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
            this.f21100e = bVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                this.f21100e.f21096h.onItemViewLongClick(this.f21100e.f21090b, 200, 0, 0L, this.f21100e.f21097i);
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
        this.f21096h = validateActivity;
        j();
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View findViewById = this.f1976a.findViewById(R.id.root_view);
            this.f21090b = findViewById;
            HeadImageView headImageView = (HeadImageView) findViewById.findViewById(R.id.iv_head);
            this.f21091c = headImageView;
            headImageView.setIsRound(false);
            this.f21092d = (TextView) this.f21090b.findViewById(R.id.tv_user_name);
            this.f21093e = (TextView) this.f21090b.findViewById(R.id.tv_group_name);
            this.f21094f = (TextView) this.f21090b.findViewById(R.id.tv_apply_reason);
            TextView textView = (TextView) this.f21090b.findViewById(R.id.btn_pass);
            this.f21095g = textView;
            textView.setOnClickListener(new a(this));
            this.f21091c.setOnClickListener(new View$OnClickListenerC0982b(this));
            this.f21090b.setOnLongClickListener(new c(this));
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
            this.f21097i = validateItemData;
        }
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f21097i == null) {
            return;
        }
        this.f21096h.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
        this.f21096h.getLayoutMode().j(this.f21090b);
        String portrait = this.f21097i.getPortrait();
        this.f21091c.setTag(portrait);
        this.f21091c.startLoad(portrait, 12, false);
        if (!TextUtils.isEmpty(this.f21097i.getUserName())) {
            this.f21092d.setText(this.f21097i.getUserName());
        }
        if (!TextUtils.isEmpty(this.f21097i.getGroupName())) {
            TextView textView = this.f21093e;
            textView.setText(this.f21096h.getPageContext().getString(R.string.validate_im_apply_prefix) + this.f21097i.getGroupName());
        }
        if (!TextUtils.isEmpty(this.f21097i.getApplyReason())) {
            TextView textView2 = this.f21094f;
            textView2.setText(this.f21096h.getPageContext().getString(R.string.validate_im_reason_prefix) + this.f21097i.getApplyReason());
        }
        if (this.f21097i.isPass()) {
            this.f21095g.setEnabled(false);
            this.f21095g.setText(this.f21096h.getPageContext().getString(R.string.passed));
            SkinManager.setViewTextColor(this.f21095g, R.color.CAM_X0109);
            this.f21095g.setBackgroundDrawable(null);
        } else {
            this.f21095g.setEnabled(true);
            this.f21095g.setText(this.f21096h.getPageContext().getString(R.string.pass));
        }
        if (this.f21097i.isShown()) {
            return;
        }
        SkinManager.setBackgroundResource(this.f21090b, R.color.common_color_10178);
    }
}

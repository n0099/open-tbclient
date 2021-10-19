package c.a.r0.l1.x;

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
    public View f21854b;

    /* renamed from: c  reason: collision with root package name */
    public HeadImageView f21855c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f21856d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f21857e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f21858f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f21859g;

    /* renamed from: h  reason: collision with root package name */
    public ValidateActivity f21860h;

    /* renamed from: i  reason: collision with root package name */
    public ValidateItemData f21861i;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f21862e;

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
            this.f21862e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f21862e.f21860h.onItemViewClick(this.f21862e.f21859g, 100, 0, 0L, this.f21862e.f21861i);
            }
        }
    }

    /* renamed from: c.a.r0.l1.x.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1022b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f21863e;

        public View$OnClickListenerC1022b(b bVar) {
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
            this.f21863e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f21863e.f21860h.onItemViewClick(this.f21863e.f21855c, 101, 0, 0L, this.f21863e.f21861i);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f21864e;

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
            this.f21864e = bVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                this.f21864e.f21860h.onItemViewLongClick(this.f21864e.f21854b, 200, 0, 0L, this.f21864e.f21861i);
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
        this.f21860h = validateActivity;
        j();
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View findViewById = this.f1976a.findViewById(R.id.root_view);
            this.f21854b = findViewById;
            HeadImageView headImageView = (HeadImageView) findViewById.findViewById(R.id.iv_head);
            this.f21855c = headImageView;
            headImageView.setIsRound(false);
            this.f21856d = (TextView) this.f21854b.findViewById(R.id.tv_user_name);
            this.f21857e = (TextView) this.f21854b.findViewById(R.id.tv_group_name);
            this.f21858f = (TextView) this.f21854b.findViewById(R.id.tv_apply_reason);
            TextView textView = (TextView) this.f21854b.findViewById(R.id.btn_pass);
            this.f21859g = textView;
            textView.setOnClickListener(new a(this));
            this.f21855c.setOnClickListener(new View$OnClickListenerC1022b(this));
            this.f21854b.setOnLongClickListener(new c(this));
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
            this.f21861i = validateItemData;
        }
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f21861i == null) {
            return;
        }
        this.f21860h.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
        this.f21860h.getLayoutMode().j(this.f21854b);
        String portrait = this.f21861i.getPortrait();
        this.f21855c.setTag(portrait);
        this.f21855c.startLoad(portrait, 12, false);
        if (!TextUtils.isEmpty(this.f21861i.getUserName())) {
            this.f21856d.setText(this.f21861i.getUserName());
        }
        if (!TextUtils.isEmpty(this.f21861i.getGroupName())) {
            TextView textView = this.f21857e;
            textView.setText(this.f21860h.getPageContext().getString(R.string.validate_im_apply_prefix) + this.f21861i.getGroupName());
        }
        if (!TextUtils.isEmpty(this.f21861i.getApplyReason())) {
            TextView textView2 = this.f21858f;
            textView2.setText(this.f21860h.getPageContext().getString(R.string.validate_im_reason_prefix) + this.f21861i.getApplyReason());
        }
        if (this.f21861i.isPass()) {
            this.f21859g.setEnabled(false);
            this.f21859g.setText(this.f21860h.getPageContext().getString(R.string.passed));
            SkinManager.setViewTextColor(this.f21859g, R.color.CAM_X0109);
            this.f21859g.setBackgroundDrawable(null);
        } else {
            this.f21859g.setEnabled(true);
            this.f21859g.setText(this.f21860h.getPageContext().getString(R.string.pass));
        }
        if (this.f21861i.isShown()) {
            return;
        }
        SkinManager.setBackgroundResource(this.f21854b, R.color.common_color_10178);
    }
}

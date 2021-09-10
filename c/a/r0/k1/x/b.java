package c.a.r0.k1.x;

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
    public View f21660b;

    /* renamed from: c  reason: collision with root package name */
    public HeadImageView f21661c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f21662d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f21663e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f21664f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f21665g;

    /* renamed from: h  reason: collision with root package name */
    public ValidateActivity f21666h;

    /* renamed from: i  reason: collision with root package name */
    public ValidateItemData f21667i;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f21668e;

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
            this.f21668e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f21668e.f21666h.onItemViewClick(this.f21668e.f21665g, 100, 0, 0L, this.f21668e.f21667i);
            }
        }
    }

    /* renamed from: c.a.r0.k1.x.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1015b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f21669e;

        public View$OnClickListenerC1015b(b bVar) {
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
            this.f21669e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f21669e.f21666h.onItemViewClick(this.f21669e.f21661c, 101, 0, 0L, this.f21669e.f21667i);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f21670e;

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
            this.f21670e = bVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                this.f21670e.f21666h.onItemViewLongClick(this.f21670e.f21660b, 200, 0, 0L, this.f21670e.f21667i);
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
        this.f21666h = validateActivity;
        j();
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View findViewById = this.f1976a.findViewById(R.id.root_view);
            this.f21660b = findViewById;
            HeadImageView headImageView = (HeadImageView) findViewById.findViewById(R.id.iv_head);
            this.f21661c = headImageView;
            headImageView.setIsRound(false);
            this.f21662d = (TextView) this.f21660b.findViewById(R.id.tv_user_name);
            this.f21663e = (TextView) this.f21660b.findViewById(R.id.tv_group_name);
            this.f21664f = (TextView) this.f21660b.findViewById(R.id.tv_apply_reason);
            TextView textView = (TextView) this.f21660b.findViewById(R.id.btn_pass);
            this.f21665g = textView;
            textView.setOnClickListener(new a(this));
            this.f21661c.setOnClickListener(new View$OnClickListenerC1015b(this));
            this.f21660b.setOnLongClickListener(new c(this));
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
            this.f21667i = validateItemData;
        }
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f21667i == null) {
            return;
        }
        this.f21666h.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
        this.f21666h.getLayoutMode().j(this.f21660b);
        String portrait = this.f21667i.getPortrait();
        this.f21661c.setTag(portrait);
        this.f21661c.startLoad(portrait, 12, false);
        if (!TextUtils.isEmpty(this.f21667i.getUserName())) {
            this.f21662d.setText(this.f21667i.getUserName());
        }
        if (!TextUtils.isEmpty(this.f21667i.getGroupName())) {
            TextView textView = this.f21663e;
            textView.setText(this.f21666h.getPageContext().getString(R.string.validate_im_apply_prefix) + this.f21667i.getGroupName());
        }
        if (!TextUtils.isEmpty(this.f21667i.getApplyReason())) {
            TextView textView2 = this.f21664f;
            textView2.setText(this.f21666h.getPageContext().getString(R.string.validate_im_reason_prefix) + this.f21667i.getApplyReason());
        }
        if (this.f21667i.isPass()) {
            this.f21665g.setEnabled(false);
            this.f21665g.setText(this.f21666h.getPageContext().getString(R.string.passed));
            SkinManager.setViewTextColor(this.f21665g, R.color.CAM_X0109);
            this.f21665g.setBackgroundDrawable(null);
        } else {
            this.f21665g.setEnabled(true);
            this.f21665g.setText(this.f21666h.getPageContext().getString(R.string.pass));
        }
        if (this.f21667i.isShown()) {
            return;
        }
        SkinManager.setBackgroundResource(this.f21660b, R.color.common_color_10178);
    }
}

package c.a.r0.r1.x;

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
/* loaded from: classes6.dex */
public class b extends c.a.d.a.c<ValidateActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public View f23167b;

    /* renamed from: c  reason: collision with root package name */
    public HeadImageView f23168c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f23169d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f23170e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f23171f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f23172g;

    /* renamed from: h  reason: collision with root package name */
    public ValidateActivity f23173h;

    /* renamed from: i  reason: collision with root package name */
    public ValidateItemData f23174i;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f23175e;

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
            this.f23175e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f23175e.f23173h.onItemViewClick(this.f23175e.f23172g, 100, 0, 0L, this.f23175e.f23174i);
            }
        }
    }

    /* renamed from: c.a.r0.r1.x.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class View$OnClickListenerC1339b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f23176e;

        public View$OnClickListenerC1339b(b bVar) {
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
            this.f23176e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f23176e.f23173h.onItemViewClick(this.f23176e.f23168c, 101, 0, 0L, this.f23176e.f23174i);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f23177e;

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
            this.f23177e = bVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                this.f23177e.f23173h.onItemViewLongClick(this.f23177e.f23167b, 200, 0, 0L, this.f23177e.f23174i);
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
        this.f23173h = validateActivity;
        j();
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View findViewById = this.a.findViewById(R.id.root_view);
            this.f23167b = findViewById;
            HeadImageView headImageView = (HeadImageView) findViewById.findViewById(R.id.iv_head);
            this.f23168c = headImageView;
            headImageView.setIsRound(false);
            this.f23169d = (TextView) this.f23167b.findViewById(R.id.tv_user_name);
            this.f23170e = (TextView) this.f23167b.findViewById(R.id.tv_group_name);
            this.f23171f = (TextView) this.f23167b.findViewById(R.id.tv_apply_reason);
            TextView textView = (TextView) this.f23167b.findViewById(R.id.btn_pass);
            this.f23172g = textView;
            textView.setOnClickListener(new a(this));
            this.f23168c.setOnClickListener(new View$OnClickListenerC1339b(this));
            this.f23167b.setOnLongClickListener(new c(this));
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
            this.f23174i = validateItemData;
        }
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f23174i == null) {
            return;
        }
        this.f23173h.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
        this.f23173h.getLayoutMode().j(this.f23167b);
        String portrait = this.f23174i.getPortrait();
        this.f23168c.setTag(portrait);
        this.f23168c.startLoad(portrait, 12, false);
        if (!TextUtils.isEmpty(this.f23174i.getUserName())) {
            this.f23169d.setText(this.f23174i.getUserName());
        }
        if (!TextUtils.isEmpty(this.f23174i.getGroupName())) {
            TextView textView = this.f23170e;
            textView.setText(this.f23173h.getPageContext().getString(R.string.validate_im_apply_prefix) + this.f23174i.getGroupName());
        }
        if (!TextUtils.isEmpty(this.f23174i.getApplyReason())) {
            TextView textView2 = this.f23171f;
            textView2.setText(this.f23173h.getPageContext().getString(R.string.validate_im_reason_prefix) + this.f23174i.getApplyReason());
        }
        if (this.f23174i.isPass()) {
            this.f23172g.setEnabled(false);
            this.f23172g.setText(this.f23173h.getPageContext().getString(R.string.passed));
            SkinManager.setViewTextColor(this.f23172g, R.color.CAM_X0109);
            this.f23172g.setBackgroundDrawable(null);
        } else {
            this.f23172g.setEnabled(true);
            this.f23172g.setText(this.f23173h.getPageContext().getString(R.string.pass));
        }
        if (this.f23174i.isShown()) {
            return;
        }
        SkinManager.setBackgroundResource(this.f23167b, R.color.common_color_10178);
    }
}

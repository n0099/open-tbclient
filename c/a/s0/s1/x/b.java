package c.a.s0.s1.x;

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
/* loaded from: classes8.dex */
public class b extends c.a.d.a.c<ValidateActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public View f22395b;

    /* renamed from: c  reason: collision with root package name */
    public HeadImageView f22396c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f22397d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f22398e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f22399f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f22400g;

    /* renamed from: h  reason: collision with root package name */
    public ValidateActivity f22401h;

    /* renamed from: i  reason: collision with root package name */
    public ValidateItemData f22402i;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f22403e;

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
            this.f22403e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f22403e.f22401h.onItemViewClick(this.f22403e.f22400g, 100, 0, 0L, this.f22403e.f22402i);
            }
        }
    }

    /* renamed from: c.a.s0.s1.x.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1338b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f22404e;

        public View$OnClickListenerC1338b(b bVar) {
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
            this.f22404e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f22404e.f22401h.onItemViewClick(this.f22404e.f22396c, 101, 0, 0L, this.f22404e.f22402i);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f22405e;

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
            this.f22405e = bVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                this.f22405e.f22401h.onItemViewLongClick(this.f22405e.f22395b, 200, 0, 0L, this.f22405e.f22402i);
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
        this.f22401h = validateActivity;
        j();
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View findViewById = this.a.findViewById(R.id.root_view);
            this.f22395b = findViewById;
            HeadImageView headImageView = (HeadImageView) findViewById.findViewById(R.id.iv_head);
            this.f22396c = headImageView;
            headImageView.setIsRound(false);
            this.f22397d = (TextView) this.f22395b.findViewById(R.id.tv_user_name);
            this.f22398e = (TextView) this.f22395b.findViewById(R.id.tv_group_name);
            this.f22399f = (TextView) this.f22395b.findViewById(R.id.tv_apply_reason);
            TextView textView = (TextView) this.f22395b.findViewById(R.id.btn_pass);
            this.f22400g = textView;
            textView.setOnClickListener(new a(this));
            this.f22396c.setOnClickListener(new View$OnClickListenerC1338b(this));
            this.f22395b.setOnLongClickListener(new c(this));
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
            this.f22402i = validateItemData;
        }
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f22402i == null) {
            return;
        }
        this.f22401h.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
        this.f22401h.getLayoutMode().j(this.f22395b);
        String portrait = this.f22402i.getPortrait();
        this.f22396c.setTag(portrait);
        this.f22396c.startLoad(portrait, 12, false);
        if (!TextUtils.isEmpty(this.f22402i.getUserName())) {
            this.f22397d.setText(this.f22402i.getUserName());
        }
        if (!TextUtils.isEmpty(this.f22402i.getGroupName())) {
            TextView textView = this.f22398e;
            textView.setText(this.f22401h.getPageContext().getString(R.string.validate_im_apply_prefix) + this.f22402i.getGroupName());
        }
        if (!TextUtils.isEmpty(this.f22402i.getApplyReason())) {
            TextView textView2 = this.f22399f;
            textView2.setText(this.f22401h.getPageContext().getString(R.string.validate_im_reason_prefix) + this.f22402i.getApplyReason());
        }
        if (this.f22402i.isPass()) {
            this.f22400g.setEnabled(false);
            this.f22400g.setText(this.f22401h.getPageContext().getString(R.string.passed));
            SkinManager.setViewTextColor(this.f22400g, R.color.CAM_X0109);
            this.f22400g.setBackgroundDrawable(null);
        } else {
            this.f22400g.setEnabled(true);
            this.f22400g.setText(this.f22401h.getPageContext().getString(R.string.pass));
        }
        if (this.f22402i.isShown()) {
            return;
        }
        SkinManager.setBackgroundResource(this.f22395b, R.color.common_color_10178);
    }
}

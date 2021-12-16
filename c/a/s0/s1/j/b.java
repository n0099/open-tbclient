package c.a.s0.s1.j;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.UpdatesItemData;
import com.baidu.tieba.im.groupUpdates.UpdatesActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
/* loaded from: classes8.dex */
public class b extends c.a.d.a.c<UpdatesActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public View f22232b;

    /* renamed from: c  reason: collision with root package name */
    public HeadImageView f22233c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f22234d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f22235e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f22236f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f22237g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f22238h;

    /* renamed from: i  reason: collision with root package name */
    public RelativeLayout f22239i;

    /* renamed from: j  reason: collision with root package name */
    public RelativeLayout f22240j;

    /* renamed from: k  reason: collision with root package name */
    public UpdatesActivity f22241k;
    public UpdatesItemData l;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            }
        }
    }

    /* renamed from: c.a.s0.s1.j.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1323b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f22242e;

        public View$OnClickListenerC1323b(b bVar) {
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
            this.f22242e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f22242e.f22241k.isEditMode()) {
                    this.f22242e.f22238h.performClick();
                } else {
                    this.f22242e.f22241k.onItemViewClick(this.f22242e.f22232b, 101, 0, 0L, this.f22242e.l);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f22243e;

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
            this.f22243e = bVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                this.f22243e.f22241k.onItemViewLongClick(this.f22243e.f22232b, 200, 0, 0L, this.f22243e.l);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f22244e;

        public d(b bVar) {
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
            this.f22244e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f22244e.f22241k.onItemViewClick(this.f22244e.f22232b, 101, 0, 0L, this.f22244e.l);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f22245e;

        public e(b bVar) {
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
            this.f22245e = bVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                this.f22245e.f22241k.onItemViewLongClick(this.f22245e.f22232b, 200, 0, 0L, this.f22245e.l);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f22246e;

        public f(b bVar) {
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
            this.f22246e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                view.setSelected(!view.isSelected());
                this.f22246e.f22241k.onCheckedChanged(view, view.isSelected(), this.f22246e.l);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext(), R.layout.updates_item);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {updatesActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((c.a.d.a.f) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f22241k = updatesActivity;
        i();
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View findViewById = this.a.findViewById(R.id.root_view);
            this.f22232b = findViewById;
            this.f22233c = (HeadImageView) findViewById.findViewById(R.id.iv_head);
            this.f22234d = (TextView) this.f22232b.findViewById(R.id.tv_group_name);
            this.f22235e = (TextView) this.f22232b.findViewById(R.id.tv_content);
            this.f22236f = (TextView) this.f22232b.findViewById(R.id.tv_title);
            this.f22237g = (TextView) this.f22232b.findViewById(R.id.tv_time);
            this.f22238h = (ImageView) this.f22232b.findViewById(R.id.cb_select);
            this.f22239i = (RelativeLayout) this.f22232b.findViewById(R.id.layout_body);
            this.f22240j = (RelativeLayout) this.f22232b.findViewById(R.id.layout_title);
            this.f22233c.setOnClickListener(new a(this));
            this.f22239i.setClickable(true);
            this.f22239i.setLongClickable(true);
            this.f22240j.setClickable(true);
            this.f22240j.setLongClickable(true);
            this.f22239i.setOnClickListener(new View$OnClickListenerC1323b(this));
            this.f22239i.setOnLongClickListener(new c(this));
            this.f22240j.setOnClickListener(new d(this));
            this.f22240j.setOnLongClickListener(new e(this));
            this.f22238h.setOnClickListener(new f(this));
        }
    }

    public void j(UpdatesItemData updatesItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, updatesItemData) == null) {
            k(updatesItemData);
            refresh();
        }
    }

    public void k(UpdatesItemData updatesItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, updatesItemData) == null) {
            this.l = updatesItemData;
        }
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.l == null) {
            return;
        }
        if (this.f22241k.isEditMode()) {
            this.f22238h.setVisibility(0);
        } else {
            this.f22238h.setVisibility(8);
            this.f22239i.setSelected(false);
        }
        String groupHeadUrl = this.l.getGroupHeadUrl();
        if (!TextUtils.isEmpty(groupHeadUrl)) {
            this.f22233c.setTag(groupHeadUrl);
            this.f22233c.startLoad(groupHeadUrl, 10, false);
        } else {
            this.f22233c.setTag(null);
        }
        this.f22233c.setClickable(false);
        if (!TextUtils.isEmpty(this.l.getTitle())) {
            this.f22236f.setText(this.l.getTitle());
        } else {
            this.f22236f.setText(this.f22241k.getPageContext().getString(R.string.inform));
        }
        Date date = new Date();
        date.setTime(this.l.getTime());
        this.f22237g.setText(StringHelper.getPostTimeString(date));
        if (!TextUtils.isEmpty(this.l.getContent())) {
            this.f22235e.setText(this.l.getContent());
        } else {
            this.f22235e.setText("");
        }
        if (!TextUtils.isEmpty(this.l.getGroupName())) {
            this.f22234d.setText(this.l.getGroupName());
        } else {
            this.f22234d.setText("");
        }
        int paddingLeft = this.f22239i.getPaddingLeft();
        int paddingTop = this.f22239i.getPaddingTop();
        int paddingRight = this.f22239i.getPaddingRight();
        int paddingBottom = this.f22239i.getPaddingBottom();
        this.f22241k.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
        this.f22241k.getLayoutMode().j(this.a);
        this.f22238h.setSelected(this.l.isSelected());
        if (this.l.isSelected() && this.f22241k.isEditMode()) {
            SkinManager.setBackgroundResource(this.f22239i, R.drawable.bg_information_down_s);
        } else {
            SkinManager.setBackgroundResource(this.f22239i, R.drawable.selector_group_updates_bottom_bg);
        }
        this.f22239i.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }
}

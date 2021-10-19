package c.a.r0.l1.j;

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
/* loaded from: classes3.dex */
public class b extends c.a.e.a.c<UpdatesActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public View f21623b;

    /* renamed from: c  reason: collision with root package name */
    public HeadImageView f21624c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f21625d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f21626e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f21627f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f21628g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f21629h;

    /* renamed from: i  reason: collision with root package name */
    public RelativeLayout f21630i;

    /* renamed from: j  reason: collision with root package name */
    public RelativeLayout f21631j;
    public UpdatesActivity k;
    public UpdatesItemData l;

    /* loaded from: classes3.dex */
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

    /* renamed from: c.a.r0.l1.j.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1007b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f21632e;

        public View$OnClickListenerC1007b(b bVar) {
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
            this.f21632e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f21632e.k.isEditMode()) {
                    this.f21632e.f21629h.performClick();
                } else {
                    this.f21632e.k.onItemViewClick(this.f21632e.f21623b, 101, 0, 0L, this.f21632e.l);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f21633e;

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
            this.f21633e = bVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                this.f21633e.k.onItemViewLongClick(this.f21633e.f21623b, 200, 0, 0L, this.f21633e.l);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f21634e;

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
            this.f21634e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f21634e.k.onItemViewClick(this.f21634e.f21623b, 101, 0, 0L, this.f21634e.l);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f21635e;

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
            this.f21635e = bVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                this.f21635e.k.onItemViewLongClick(this.f21635e.f21623b, 200, 0, 0L, this.f21635e.l);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f21636e;

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
            this.f21636e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                view.setSelected(!view.isSelected());
                this.f21636e.k.onCheckedChanged(view, view.isSelected(), this.f21636e.l);
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
                super((c.a.e.a.f) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = updatesActivity;
        i();
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View findViewById = this.f1976a.findViewById(R.id.root_view);
            this.f21623b = findViewById;
            this.f21624c = (HeadImageView) findViewById.findViewById(R.id.iv_head);
            this.f21625d = (TextView) this.f21623b.findViewById(R.id.tv_group_name);
            this.f21626e = (TextView) this.f21623b.findViewById(R.id.tv_content);
            this.f21627f = (TextView) this.f21623b.findViewById(R.id.tv_title);
            this.f21628g = (TextView) this.f21623b.findViewById(R.id.tv_time);
            this.f21629h = (ImageView) this.f21623b.findViewById(R.id.cb_select);
            this.f21630i = (RelativeLayout) this.f21623b.findViewById(R.id.layout_body);
            this.f21631j = (RelativeLayout) this.f21623b.findViewById(R.id.layout_title);
            this.f21624c.setOnClickListener(new a(this));
            this.f21630i.setClickable(true);
            this.f21630i.setLongClickable(true);
            this.f21631j.setClickable(true);
            this.f21631j.setLongClickable(true);
            this.f21630i.setOnClickListener(new View$OnClickListenerC1007b(this));
            this.f21630i.setOnLongClickListener(new c(this));
            this.f21631j.setOnClickListener(new d(this));
            this.f21631j.setOnLongClickListener(new e(this));
            this.f21629h.setOnClickListener(new f(this));
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
        if (this.k.isEditMode()) {
            this.f21629h.setVisibility(0);
        } else {
            this.f21629h.setVisibility(8);
            this.f21630i.setSelected(false);
        }
        String groupHeadUrl = this.l.getGroupHeadUrl();
        if (!TextUtils.isEmpty(groupHeadUrl)) {
            this.f21624c.setTag(groupHeadUrl);
            this.f21624c.startLoad(groupHeadUrl, 10, false);
        } else {
            this.f21624c.setTag(null);
        }
        this.f21624c.setClickable(false);
        if (!TextUtils.isEmpty(this.l.getTitle())) {
            this.f21627f.setText(this.l.getTitle());
        } else {
            this.f21627f.setText(this.k.getPageContext().getString(R.string.inform));
        }
        Date date = new Date();
        date.setTime(this.l.getTime());
        this.f21628g.setText(StringHelper.getPostTimeString(date));
        if (!TextUtils.isEmpty(this.l.getContent())) {
            this.f21626e.setText(this.l.getContent());
        } else {
            this.f21626e.setText("");
        }
        if (!TextUtils.isEmpty(this.l.getGroupName())) {
            this.f21625d.setText(this.l.getGroupName());
        } else {
            this.f21625d.setText("");
        }
        int paddingLeft = this.f21630i.getPaddingLeft();
        int paddingTop = this.f21630i.getPaddingTop();
        int paddingRight = this.f21630i.getPaddingRight();
        int paddingBottom = this.f21630i.getPaddingBottom();
        this.k.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
        this.k.getLayoutMode().j(this.f1976a);
        this.f21629h.setSelected(this.l.isSelected());
        if (this.l.isSelected() && this.k.isEditMode()) {
            SkinManager.setBackgroundResource(this.f21630i, R.drawable.bg_information_down_s);
        } else {
            SkinManager.setBackgroundResource(this.f21630i, R.drawable.selector_group_updates_bottom_bg);
        }
        this.f21630i.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }
}

package b.a.r0.l1.j;

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
/* loaded from: classes5.dex */
public class b extends b.a.e.a.c<UpdatesActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public View f20210b;

    /* renamed from: c  reason: collision with root package name */
    public HeadImageView f20211c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f20212d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f20213e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f20214f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f20215g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f20216h;

    /* renamed from: i  reason: collision with root package name */
    public RelativeLayout f20217i;
    public RelativeLayout j;
    public UpdatesActivity k;
    public UpdatesItemData l;

    /* loaded from: classes5.dex */
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

    /* renamed from: b.a.r0.l1.j.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1001b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f20218e;

        public View$OnClickListenerC1001b(b bVar) {
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
            this.f20218e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f20218e.k.isEditMode()) {
                    this.f20218e.f20216h.performClick();
                } else {
                    this.f20218e.k.onItemViewClick(this.f20218e.f20210b, 101, 0, 0L, this.f20218e.l);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f20219e;

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
            this.f20219e = bVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                this.f20219e.k.onItemViewLongClick(this.f20219e.f20210b, 200, 0, 0L, this.f20219e.l);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f20220e;

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
            this.f20220e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f20220e.k.onItemViewClick(this.f20220e.f20210b, 101, 0, 0L, this.f20220e.l);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f20221e;

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
            this.f20221e = bVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                this.f20221e.k.onItemViewLongClick(this.f20221e.f20210b, 200, 0, 0L, this.f20221e.l);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f20222e;

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
            this.f20222e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                view.setSelected(!view.isSelected());
                this.f20222e.k.onCheckedChanged(view, view.isSelected(), this.f20222e.l);
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
                super((b.a.e.a.f) objArr2[0], ((Integer) objArr2[1]).intValue());
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
            View findViewById = this.f1463a.findViewById(R.id.root_view);
            this.f20210b = findViewById;
            this.f20211c = (HeadImageView) findViewById.findViewById(R.id.iv_head);
            this.f20212d = (TextView) this.f20210b.findViewById(R.id.tv_group_name);
            this.f20213e = (TextView) this.f20210b.findViewById(R.id.tv_content);
            this.f20214f = (TextView) this.f20210b.findViewById(R.id.tv_title);
            this.f20215g = (TextView) this.f20210b.findViewById(R.id.tv_time);
            this.f20216h = (ImageView) this.f20210b.findViewById(R.id.cb_select);
            this.f20217i = (RelativeLayout) this.f20210b.findViewById(R.id.layout_body);
            this.j = (RelativeLayout) this.f20210b.findViewById(R.id.layout_title);
            this.f20211c.setOnClickListener(new a(this));
            this.f20217i.setClickable(true);
            this.f20217i.setLongClickable(true);
            this.j.setClickable(true);
            this.j.setLongClickable(true);
            this.f20217i.setOnClickListener(new View$OnClickListenerC1001b(this));
            this.f20217i.setOnLongClickListener(new c(this));
            this.j.setOnClickListener(new d(this));
            this.j.setOnLongClickListener(new e(this));
            this.f20216h.setOnClickListener(new f(this));
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
            this.f20216h.setVisibility(0);
        } else {
            this.f20216h.setVisibility(8);
            this.f20217i.setSelected(false);
        }
        String groupHeadUrl = this.l.getGroupHeadUrl();
        if (!TextUtils.isEmpty(groupHeadUrl)) {
            this.f20211c.setTag(groupHeadUrl);
            this.f20211c.startLoad(groupHeadUrl, 10, false);
        } else {
            this.f20211c.setTag(null);
        }
        this.f20211c.setClickable(false);
        if (!TextUtils.isEmpty(this.l.getTitle())) {
            this.f20214f.setText(this.l.getTitle());
        } else {
            this.f20214f.setText(this.k.getPageContext().getString(R.string.inform));
        }
        Date date = new Date();
        date.setTime(this.l.getTime());
        this.f20215g.setText(StringHelper.getPostTimeString(date));
        if (!TextUtils.isEmpty(this.l.getContent())) {
            this.f20213e.setText(this.l.getContent());
        } else {
            this.f20213e.setText("");
        }
        if (!TextUtils.isEmpty(this.l.getGroupName())) {
            this.f20212d.setText(this.l.getGroupName());
        } else {
            this.f20212d.setText("");
        }
        int paddingLeft = this.f20217i.getPaddingLeft();
        int paddingTop = this.f20217i.getPaddingTop();
        int paddingRight = this.f20217i.getPaddingRight();
        int paddingBottom = this.f20217i.getPaddingBottom();
        this.k.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
        this.k.getLayoutMode().j(this.f1463a);
        this.f20216h.setSelected(this.l.isSelected());
        if (this.l.isSelected() && this.k.isEditMode()) {
            SkinManager.setBackgroundResource(this.f20217i, R.drawable.bg_information_down_s);
        } else {
            SkinManager.setBackgroundResource(this.f20217i, R.drawable.selector_group_updates_bottom_bg);
        }
        this.f20217i.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }
}

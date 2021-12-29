package c.a.t0.x1;

import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.t0.w3.w;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.activity.LegoListActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final NavigationBar a;

    /* renamed from: b  reason: collision with root package name */
    public final RelativeLayout f25892b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f25893c;

    /* renamed from: d  reason: collision with root package name */
    public final TbImageView f25894d;

    /* renamed from: e  reason: collision with root package name */
    public final View f25895e;

    /* renamed from: f  reason: collision with root package name */
    public final LinearLayout f25896f;

    /* renamed from: g  reason: collision with root package name */
    public final TbImageView f25897g;

    /* renamed from: h  reason: collision with root package name */
    public final TbImageView f25898h;

    /* renamed from: i  reason: collision with root package name */
    public final TbImageView f25899i;

    /* renamed from: j  reason: collision with root package name */
    public final List<TbImageView> f25900j;

    /* renamed from: k  reason: collision with root package name */
    public LegoListActivity f25901k;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f25902e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f25903f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ j f25904g;

        public a(j jVar, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25904g = jVar;
            this.f25902e = str;
            this.f25903f = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f25904g.f(this.f25902e, this.f25903f);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f25905e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ j f25906f;

        public b(j jVar, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25906f = jVar;
            this.f25905e = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f25906f.e(this.f25905e);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f25907e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ j f25908f;

        public c(j jVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25908f = jVar;
            this.f25907e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                w.c(this.f25908f.f25901k.getPageContext(), this.f25907e);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.t0.x1.p.d f25909e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ j f25910f;

        public d(j jVar, c.a.t0.x1.p.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25910f = jVar;
            this.f25909e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f25910f.h(this.f25909e);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareItem f25911e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ j f25912f;

        public e(j jVar, ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, shareItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25912f = jVar;
            this.f25911e = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.d.f.p.c.a(this.f25911e.t);
                n.M(this.f25912f.f25901k.getActivity(), view.getResources().getString(R.string.copy_pb_url_success));
            }
        }
    }

    public j(LegoListActivity legoListActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {legoListActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f25901k = legoListActivity;
        NavigationBar navigationBar = (NavigationBar) legoListActivity.findViewById(R.id.view_navigation_bar);
        this.a = navigationBar;
        this.f25895e = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, legoListActivity.mCommonOnClickListener);
        this.f25892b = (RelativeLayout) this.a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.title_textview, (View.OnClickListener) null);
        ((LinearLayout) this.a.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_CENTER)).setGravity(17);
        this.f25893c = (TextView) this.f25892b.findViewById(R.id.lego_title);
        this.f25894d = (TbImageView) this.f25892b.findViewById(R.id.lego_title_img);
        LinearLayout linearLayout = (LinearLayout) this.f25892b.findViewById(R.id.ll_right);
        this.f25896f = linearLayout;
        this.f25897g = (TbImageView) linearLayout.findViewById(R.id.iv1);
        this.f25898h = (TbImageView) this.f25896f.findViewById(R.id.iv2);
        this.f25899i = (TbImageView) this.f25896f.findViewById(R.id.iv3);
        ArrayList arrayList = new ArrayList();
        this.f25900j = arrayList;
        arrayList.add(this.f25897g);
        this.f25900j.add(this.f25898h);
        this.f25900j.add(this.f25899i);
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.setVisibility(8);
        }
    }

    public final void e(List<c.a.t0.x1.p.d> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.f25896f.setVisibility(0);
        for (int i2 = 0; i2 < list.size() && i2 < this.f25900j.size(); i2++) {
            this.f25900j.get(i2).setVisibility(0);
            if (list.get(i2).f26016d == 2) {
                SkinManager.setImageResource(this.f25900j.get(i2), R.drawable.icon_nav_share_n);
            } else if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                this.f25900j.get(i2).startLoad(list.get(i2).f26014b, 10, false);
            } else {
                this.f25900j.get(i2).startLoad(list.get(i2).a, 10, false);
            }
            if (!TextUtils.isEmpty(list.get(i2).f26015c)) {
                String str = list.get(i2).f26015c;
                if (list.get(i2).f26016d == 1) {
                    this.f25900j.get(i2).setOnClickListener(new c(this, str));
                } else if (list.get(i2).f26016d == 2) {
                    this.f25900j.get(i2).setOnClickListener(new d(this, list.get(i2)));
                }
            }
        }
        for (int size = list.size(); size < this.f25900j.size(); size++) {
            this.f25900j.get(size).setVisibility(8);
        }
    }

    public final void f(String str, String str2) {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) || (tbImageView = this.f25894d) == null || this.f25893c == null) {
            return;
        }
        tbImageView.setVisibility(0);
        this.f25893c.setVisibility(8);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.f25894d.startLoad(str2, 10, false);
        } else {
            this.f25894d.startLoad(str, 10, false);
        }
    }

    public void g(List<c.a.t0.x1.p.d> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            if (ListUtils.isEmpty(list)) {
                this.f25896f.setVisibility(8);
                return;
            }
            e(list);
            this.f25896f.postDelayed(new b(this, list), 1000L);
        }
    }

    public void h(c.a.t0.x1.p.d dVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) && dVar != null && dVar.f26016d == 2) {
            String str = dVar.f26019g;
            Uri parse = str == null ? null : Uri.parse(str);
            ShareItem shareItem = new ShareItem();
            shareItem.r = dVar.f26017e;
            shareItem.s = dVar.f26018f;
            shareItem.t = dVar.f26015c;
            if (parse != null) {
                shareItem.v = parse;
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.f25901k.getActivity(), shareItem, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.setCopyLinkListener(new e(this, shareItem));
            this.f25901k.sendMessage(new CustomMessage(2001276, shareDialogConfig));
        }
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            SkinManager.setViewTextColor(this.f25893c, R.color.CAM_X0105);
            this.f25893c.setVisibility(0);
            this.f25894d.setVisibility(8);
            if (!TextUtils.isEmpty(str)) {
                this.f25893c.setText(str);
            } else {
                this.f25893c.setText("");
            }
        }
    }

    public void j(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        f(str, str2);
        this.f25894d.postDelayed(new a(this, str, str2), 1000L);
    }
}

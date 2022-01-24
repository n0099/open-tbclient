package c.a.t0.y1;

import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.t0.x3.w;
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
/* loaded from: classes9.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final NavigationBar a;

    /* renamed from: b  reason: collision with root package name */
    public final RelativeLayout f25412b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f25413c;

    /* renamed from: d  reason: collision with root package name */
    public final TbImageView f25414d;

    /* renamed from: e  reason: collision with root package name */
    public final View f25415e;

    /* renamed from: f  reason: collision with root package name */
    public final LinearLayout f25416f;

    /* renamed from: g  reason: collision with root package name */
    public final TbImageView f25417g;

    /* renamed from: h  reason: collision with root package name */
    public final TbImageView f25418h;

    /* renamed from: i  reason: collision with root package name */
    public final TbImageView f25419i;

    /* renamed from: j  reason: collision with root package name */
    public final List<TbImageView> f25420j;
    public LegoListActivity k;

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f25421e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f25422f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ j f25423g;

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
            this.f25423g = jVar;
            this.f25421e = str;
            this.f25422f = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f25423g.f(this.f25421e, this.f25422f);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f25424e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ j f25425f;

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
            this.f25425f = jVar;
            this.f25424e = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f25425f.e(this.f25424e);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f25426e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ j f25427f;

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
            this.f25427f = jVar;
            this.f25426e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                w.c(this.f25427f.k.getPageContext(), this.f25426e);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.t0.y1.p.d f25428e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ j f25429f;

        public d(j jVar, c.a.t0.y1.p.d dVar) {
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
            this.f25429f = jVar;
            this.f25428e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f25429f.h(this.f25428e);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareItem f25430e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ j f25431f;

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
            this.f25431f = jVar;
            this.f25430e = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.d.f.p.c.a(this.f25430e.t);
                n.N(this.f25431f.k.getActivity(), view.getResources().getString(R.string.copy_pb_url_success));
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
        this.k = legoListActivity;
        NavigationBar navigationBar = (NavigationBar) legoListActivity.findViewById(R.id.view_navigation_bar);
        this.a = navigationBar;
        this.f25415e = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, legoListActivity.mCommonOnClickListener);
        this.f25412b = (RelativeLayout) this.a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.title_textview, (View.OnClickListener) null);
        ((LinearLayout) this.a.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_CENTER)).setGravity(17);
        this.f25413c = (TextView) this.f25412b.findViewById(R.id.lego_title);
        this.f25414d = (TbImageView) this.f25412b.findViewById(R.id.lego_title_img);
        LinearLayout linearLayout = (LinearLayout) this.f25412b.findViewById(R.id.ll_right);
        this.f25416f = linearLayout;
        this.f25417g = (TbImageView) linearLayout.findViewById(R.id.iv1);
        this.f25418h = (TbImageView) this.f25416f.findViewById(R.id.iv2);
        this.f25419i = (TbImageView) this.f25416f.findViewById(R.id.iv3);
        ArrayList arrayList = new ArrayList();
        this.f25420j = arrayList;
        arrayList.add(this.f25417g);
        this.f25420j.add(this.f25418h);
        this.f25420j.add(this.f25419i);
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.setVisibility(8);
        }
    }

    public final void e(List<c.a.t0.y1.p.d> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.f25416f.setVisibility(0);
        for (int i2 = 0; i2 < list.size() && i2 < this.f25420j.size(); i2++) {
            this.f25420j.get(i2).setVisibility(0);
            if (list.get(i2).f25529d == 2) {
                SkinManager.setImageResource(this.f25420j.get(i2), R.drawable.icon_nav_share_n);
            } else if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                this.f25420j.get(i2).startLoad(list.get(i2).f25527b, 10, false);
            } else {
                this.f25420j.get(i2).startLoad(list.get(i2).a, 10, false);
            }
            if (!TextUtils.isEmpty(list.get(i2).f25528c)) {
                String str = list.get(i2).f25528c;
                if (list.get(i2).f25529d == 1) {
                    this.f25420j.get(i2).setOnClickListener(new c(this, str));
                } else if (list.get(i2).f25529d == 2) {
                    this.f25420j.get(i2).setOnClickListener(new d(this, list.get(i2)));
                }
            }
        }
        for (int size = list.size(); size < this.f25420j.size(); size++) {
            this.f25420j.get(size).setVisibility(8);
        }
    }

    public final void f(String str, String str2) {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) || (tbImageView = this.f25414d) == null || this.f25413c == null) {
            return;
        }
        tbImageView.setVisibility(0);
        this.f25413c.setVisibility(8);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.f25414d.startLoad(str2, 10, false);
        } else {
            this.f25414d.startLoad(str, 10, false);
        }
    }

    public void g(List<c.a.t0.y1.p.d> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            if (ListUtils.isEmpty(list)) {
                this.f25416f.setVisibility(8);
                return;
            }
            e(list);
            this.f25416f.postDelayed(new b(this, list), 1000L);
        }
    }

    public void h(c.a.t0.y1.p.d dVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) && dVar != null && dVar.f25529d == 2) {
            String str = dVar.f25532g;
            Uri parse = str == null ? null : Uri.parse(str);
            ShareItem shareItem = new ShareItem();
            shareItem.r = dVar.f25530e;
            shareItem.s = dVar.f25531f;
            shareItem.t = dVar.f25528c;
            if (parse != null) {
                shareItem.v = parse;
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.k.getActivity(), shareItem, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.setCopyLinkListener(new e(this, shareItem));
            this.k.sendMessage(new CustomMessage(2001276, shareDialogConfig));
        }
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            SkinManager.setViewTextColor(this.f25413c, R.color.CAM_X0105);
            this.f25413c.setVisibility(0);
            this.f25414d.setVisibility(8);
            if (!TextUtils.isEmpty(str)) {
                this.f25413c.setText(str);
            } else {
                this.f25413c.setText("");
            }
        }
    }

    public void j(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        f(str, str2);
        this.f25414d.postDelayed(new a(this, str, str2), 1000L);
    }
}

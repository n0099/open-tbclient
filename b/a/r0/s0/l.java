package b.a.r0.s0;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.WebViewActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.FaceBuyData;
import com.baidu.tieba.faceshop.FaceBuyModel;
import com.baidu.tieba.faceshop.FacePackageData;
import com.baidu.tieba.faceshop.FacePackageDownloadData;
import com.baidu.tieba.faceshop.FacePackageDownloadModel;
import com.baidu.tieba.faceshop.FaceShopActivity;
import com.baidu.tieba.faceshop.FaceShopData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class l extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public static int o;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public FaceShopData f23323e;

    /* renamed from: f  reason: collision with root package name */
    public final FaceShopActivity f23324f;

    /* renamed from: g  reason: collision with root package name */
    public final int f23325g;

    /* renamed from: h  reason: collision with root package name */
    public final int f23326h;

    /* renamed from: i  reason: collision with root package name */
    public final int f23327i;
    public final int j;
    public int k;
    public FacePackageDownloadModel l;
    public FaceBuyModel m;
    public View.OnClickListener n;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f23328e;

        public a(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23328e = lVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                try {
                    e eVar = (e) view.getTag();
                    if (eVar == null) {
                        return;
                    }
                    int i2 = eVar.f23343a;
                    if (!TbadkCoreApplication.isLogin()) {
                        this.f23328e.k = eVar.f23343a;
                        TbadkCoreApplication.getInst().login(null, new CustomMessage<>(2002001, new LoginActivityConfig(this.f23328e.f23324f.getPageContext().getPageActivity(), true, 11003)));
                        return;
                    }
                    int i3 = eVar.f23344b;
                    if (i3 == 2) {
                        this.f23328e.i(i2);
                    } else if (i3 == 3) {
                        this.f23328e.j(i2);
                    } else if (i3 != 4) {
                    } else {
                        this.f23328e.g(i2);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends b.a.e.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FacePackageData f23329a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ l f23330b;

        public b(l lVar, FacePackageData facePackageData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar, facePackageData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23330b = lVar;
            this.f23329a = facePackageData;
        }

        @Override // b.a.e.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (obj == null || !(obj instanceof FacePackageDownloadData)) {
                    UtilHelper.showToast(this.f23330b.f23324f.getPageContext().getContext(), R.string.neterror);
                    return;
                }
                FacePackageDownloadData facePackageDownloadData = (FacePackageDownloadData) obj;
                if (facePackageDownloadData.errno == 0 && facePackageDownloadData.usermsg != null) {
                    this.f23329a.pack_url = facePackageDownloadData.pack_url;
                    f f2 = f.f();
                    String valueOf = String.valueOf(this.f23329a.pid);
                    FacePackageData facePackageData = this.f23329a;
                    f2.j(valueOf, facePackageData.pname, facePackageData.pack_url);
                } else if (facePackageDownloadData.usermsg != null) {
                    UtilHelper.showToast(this.f23330b.f23324f.getPageContext().getContext(), facePackageDownloadData.usermsg);
                } else {
                    UtilHelper.showToast(this.f23330b.f23324f.getPageContext().getContext(), R.string.neterror);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends b.a.e.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FacePackageData f23331a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f23332b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ l f23333c;

        public c(l lVar, FacePackageData facePackageData, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar, facePackageData, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23333c = lVar;
            this.f23331a = facePackageData;
            this.f23332b = i2;
        }

        @Override // b.a.e.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                this.f23333c.f23324f.hideProgressBar();
                if (obj == null || !(obj instanceof FaceBuyData)) {
                    UtilHelper.showToast(this.f23333c.f23324f.getPageContext().getContext(), R.string.neterror);
                    return;
                }
                FaceBuyData faceBuyData = (FaceBuyData) obj;
                if (faceBuyData.errno == 0 && faceBuyData.usermsg != null) {
                    FaceBuyData.BuyInfo buyInfo = faceBuyData.buy_info;
                    String str = buyInfo.buy_url;
                    String str2 = buyInfo.return_url;
                    if (buyInfo.buy_status == 2) {
                        UtilHelper.showToast(this.f23333c.f23324f.getPageContext().getContext(), R.string.has_buy_book);
                        FacePackageData facePackageData = this.f23331a;
                        facePackageData.buy_status = 1;
                        facePackageData.can_download = 1;
                        this.f23333c.notifyDataSetChanged();
                        return;
                    }
                    this.f23331a.orderId = buyInfo.order_id;
                    IntentConfig intentConfig = new IntentConfig(this.f23333c.f23324f);
                    intentConfig.getIntent().putExtra(WebViewActivityConfig.TAG_URL, str);
                    intentConfig.getIntent().putExtra("tag_hook_url", str2);
                    intentConfig.getIntent().putExtra(WebViewActivityConfig.TAG_TITLE, this.f23333c.f23324f.getString(R.string.buy_book));
                    intentConfig.getIntent().putExtra("tag_position", this.f23332b);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2902013, intentConfig));
                } else if (faceBuyData.usermsg != null) {
                    UtilHelper.showToast(this.f23333c.f23324f.getPageContext().getContext(), faceBuyData.usermsg);
                } else {
                    UtilHelper.showToast(this.f23333c.f23324f.getPageContext().getContext(), R.string.neterror);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f23334a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f23335b;

        /* renamed from: c  reason: collision with root package name */
        public FrameLayout f23336c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f23337d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f23338e;

        /* renamed from: f  reason: collision with root package name */
        public ImageView f23339f;

        /* renamed from: g  reason: collision with root package name */
        public FrameLayout f23340g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f23341h;

        /* renamed from: i  reason: collision with root package name */
        public TbImageView f23342i;
        public TbImageView j;
        public String k;
        public int l;
        public int m;

        public d(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ d(l lVar, a aVar) {
            this(lVar);
        }
    }

    /* loaded from: classes5.dex */
    public class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f23343a;

        /* renamed from: b  reason: collision with root package name */
        public int f23344b;

        public e(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ e(l lVar, a aVar) {
            this(lVar);
        }
    }

    public l(FaceShopActivity faceShopActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {faceShopActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = -1;
        this.n = new a(this);
        this.f23324f = faceShopActivity;
        int k = b.a.e.e.p.l.k(faceShopActivity.getPageContext().getPageActivity());
        o = k;
        int dimensionPixelSize = k - (faceShopActivity.getResources().getDimensionPixelSize(R.dimen.ds22) * 2);
        this.f23325g = dimensionPixelSize;
        this.f23326h = (int) (dimensionPixelSize * 0.38495576f);
        Bitmap resBitmap = BitmapHelper.getResBitmap(this.f23324f.getPageContext().getContext(), R.drawable.bg_content_download_down);
        if (resBitmap != null) {
            this.f23327i = resBitmap.getWidth();
        } else {
            this.f23327i = 0;
        }
        Bitmap resBitmap2 = BitmapHelper.getResBitmap(this.f23324f.getPageContext().getContext(), R.drawable.bg_content_download_up);
        if (resBitmap2 != null) {
            this.j = resBitmap2.getWidth();
        } else {
            this.j = 0;
        }
        this.l = null;
        this.m = null;
    }

    public View c(int i2, ViewGroup viewGroup) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i2, viewGroup)) == null) {
            if (i2 == 1) {
                d dVar = new d(this, null);
                View inflate = LayoutInflater.from(this.f23324f.getPageContext().getPageActivity()).inflate(R.layout.face_shop_list_tem, (ViewGroup) null);
                dVar.f23335b = (TextView) inflate.findViewById(R.id.title);
                dVar.f23334a = (TbImageView) inflate.findViewById(R.id.image);
                dVar.f23336c = (FrameLayout) inflate.findViewById(R.id.btn);
                dVar.f23337d = (TextView) inflate.findViewById(R.id.btn_text);
                dVar.f23338e = (TextView) inflate.findViewById(R.id.downloaded);
                dVar.f23340g = (FrameLayout) inflate.findViewById(R.id.downloading);
                dVar.f23339f = (ImageView) inflate.findViewById(R.id.downloading_up);
                dVar.f23341h = (TextView) inflate.findViewById(R.id.intro);
                TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.icon);
                dVar.f23342i = tbImageView;
                tbImageView.setDefaultResource(0);
                dVar.f23342i.setDefaultBgResource(0);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f23325g, this.f23326h);
                layoutParams.setMargins(0, 0, 0, this.f23324f.getResources().getDimensionPixelSize(R.dimen.ds8));
                dVar.f23334a.setLayoutParams(layoutParams);
                dVar.f23337d.setClickable(false);
                dVar.f23336c.setClickable(true);
                dVar.f23336c.setOnClickListener(this.n);
                dVar.j = (TbImageView) inflate.findViewById(R.id.title_tag);
                inflate.setTag(dVar);
                return inflate;
            }
            return null;
        }
        return (View) invokeIL.objValue;
    }

    public final void d(int i2, d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, dVar) == null) || this.f23323e == null || dVar == null) {
            return;
        }
        try {
            FacePackageData facePackageData = (FacePackageData) getItem(i2);
            if (facePackageData == null) {
                return;
            }
            dVar.m = i2;
            dVar.f23335b.setText(facePackageData.pname);
            dVar.f23341h.setText(facePackageData.pdesc);
            dVar.f23334a.setTag(facePackageData.banner_url);
            dVar.f23334a.startLoad(facePackageData.banner_url, 10, this.f23325g, this.f23326h, false);
            if (facePackageData.new_icon != null && facePackageData.new_icon.length() > 0) {
                dVar.f23342i.setTag(facePackageData.new_icon);
                dVar.f23342i.startLoad(facePackageData.new_icon, 21, false);
                dVar.f23342i.setVisibility(0);
            } else {
                dVar.f23342i.setVisibility(8);
            }
            dVar.k = facePackageData.price;
            r(facePackageData, dVar);
            e eVar = new e(this, null);
            eVar.f23344b = dVar.l;
            eVar.f23343a = i2;
            dVar.f23336c.setTag(eVar);
            if (!TextUtils.isEmpty(facePackageData.tag_url)) {
                dVar.j.setVisibility(0);
                dVar.j.setTag(facePackageData.tag_url);
                dVar.j.startLoad(facePackageData.tag_url, 21, false);
                return;
            }
            dVar.j.setVisibility(8);
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.k : invokeV.intValue;
    }

    public final void f(d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) || dVar == null) {
            return;
        }
        dVar.f23337d.setVisibility(8);
        dVar.f23336c.setVisibility(8);
        dVar.f23338e.setVisibility(8);
        dVar.f23340g.setVisibility(8);
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            TiebaStatic.log("emotion_package_list_buy");
            FacePackageData facePackageData = (FacePackageData) getItem(i2);
            if (this.f23323e == null) {
                return;
            }
            this.f23324f.showProgressBar();
            String valueOf = String.valueOf(facePackageData.pid);
            FaceBuyModel faceBuyModel = new FaceBuyModel(this.f23324f.getPageContext().getContext());
            this.m = faceBuyModel;
            faceBuyModel.setLoadDataCallBack(new c(this, facePackageData, i2));
            this.m.D(valueOf);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        ArrayList<FacePackageData> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            FaceShopData faceShopData = this.f23323e;
            if (faceShopData == null || (arrayList = faceShopData.pack_list) == null) {
                return 0;
            }
            return arrayList.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        ArrayList<FacePackageData> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            FaceShopData faceShopData = this.f23323e;
            if (faceShopData == null || (arrayList = faceShopData.pack_list) == null || i2 < 0 || i2 >= arrayList.size()) {
                return null;
            }
            return arrayList.get(i2);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        ArrayList<FacePackageData> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            FaceShopData faceShopData = this.f23323e;
            return (faceShopData == null || (arrayList = faceShopData.pack_list) == null || arrayList.get(i2) == null) ? 2 : 1;
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048585, this, i2, view, viewGroup)) == null) {
            int itemViewType = getItemViewType(i2);
            int skinType = TbadkApplication.getInst().getSkinType();
            if (view == null) {
                view = c(itemViewType, viewGroup);
            }
            d dVar = (d) view.getTag();
            b.a.q0.s.c layoutMode = this.f23324f.getLayoutMode();
            layoutMode.k(skinType == 1);
            layoutMode.j(view);
            d(i2, dVar);
            k(dVar);
            l(dVar, skinType);
            return view;
        }
        return (View) invokeILL.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return 3;
        }
        return invokeV.intValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            FaceBuyModel faceBuyModel = this.m;
            if (faceBuyModel != null) {
                faceBuyModel.cancelLoadData();
            }
            FacePackageDownloadModel facePackageDownloadModel = this.l;
            if (facePackageDownloadModel != null) {
                facePackageDownloadModel.cancelLoadData();
            }
        }
    }

    public void i(int i2) {
        FacePackageData facePackageData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || (facePackageData = (FacePackageData) getItem(i2)) == null) {
            return;
        }
        facePackageData.downloading = 1;
        notifyDataSetChanged();
        FacePackageDownloadModel facePackageDownloadModel = new FacePackageDownloadModel(this.f23324f.getPageContext().getContext());
        this.l = facePackageDownloadModel;
        facePackageDownloadModel.D(String.valueOf(facePackageData.pid));
        this.l.setLoadDataCallBack(new b(this, facePackageData));
    }

    public void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            TiebaStatic.log("emotion_package_list_free");
            FacePackageData facePackageData = (FacePackageData) getItem(i2);
            if (facePackageData == null) {
                return;
            }
            facePackageData.buy_status = 1;
            notifyDataSetChanged();
        }
    }

    public final void k(d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, dVar) == null) || dVar == null) {
            return;
        }
        f(dVar);
        int i2 = dVar.l;
        if (i2 == 1) {
            dVar.f23338e.setVisibility(0);
        } else if (i2 == 2 || i2 == 3 || i2 == 4) {
            dVar.f23336c.setVisibility(0);
            dVar.f23337d.setVisibility(0);
        } else if (i2 != 5) {
        } else {
            dVar.f23340g.setVisibility(0);
        }
    }

    public final void l(d dVar, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048591, this, dVar, i2) == null) || dVar == null) {
            return;
        }
        int i3 = dVar.l;
        if (i3 == 5) {
            p(dVar, i2);
        } else if (i3 == 2) {
            o(dVar, i2);
        } else if (i3 == 3) {
            q(dVar, i2);
        } else if (i3 != 4) {
        } else {
            m(dVar, i2);
        }
    }

    public final void m(d dVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048592, this, dVar, i2) == null) {
            dVar.f23337d.setText(dVar.k);
            dVar.f23337d.setBackgroundResource(0);
            SkinManager.setBackgroundResource(dVar.f23336c, R.drawable.faceshop_list_btn_selector);
        }
    }

    public void n(FaceShopData faceShopData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, faceShopData) == null) {
            this.f23323e = faceShopData;
            notifyDataSetChanged();
        }
    }

    public final void o(d dVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048594, this, dVar, i2) == null) {
            dVar.f23337d.setText((CharSequence) null);
            SkinManager.setBackgroundResource(dVar.f23336c, R.drawable.btn_all_blue);
            SkinManager.setBackgroundResource(dVar.f23337d, R.drawable.icon_content_download);
        }
    }

    public final void p(d dVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048595, this, dVar, i2) == null) {
            f(dVar);
            dVar.f23340g.setVisibility(0);
            FacePackageData facePackageData = (FacePackageData) getItem(dVar.m);
            if (facePackageData == null) {
                return;
            }
            int i3 = (int) (this.f23327i * (((float) facePackageData.downloadNow) / ((float) facePackageData.downloadTotal)));
            int i4 = this.j;
            if (i3 < i4) {
                i3 = i4;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) dVar.f23339f.getLayoutParams();
            layoutParams.width = i3;
            dVar.f23339f.setLayoutParams(layoutParams);
        }
    }

    public final void q(d dVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048596, this, dVar, i2) == null) {
            dVar.f23337d.setText(dVar.k);
            dVar.f23337d.setBackgroundResource(0);
            SkinManager.setBackgroundResource(dVar.f23336c, R.drawable.btn_all_white);
        }
    }

    public final void r(FacePackageData facePackageData, d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048597, this, facePackageData, dVar) == null) || facePackageData == null || dVar == null) {
            return;
        }
        int i2 = facePackageData.buy_status;
        int i3 = facePackageData.can_download;
        int i4 = facePackageData.downloaded;
        if (facePackageData.downloading == 1) {
            dVar.l = 5;
        } else if (i4 == 1) {
            dVar.l = 1;
        } else if (i2 == 2) {
            dVar.l = 6;
        } else if (i2 == 1) {
            if (i3 == 1) {
                dVar.l = 2;
            }
        } else if (i2 == 0) {
            if (i3 == 1) {
                dVar.l = 3;
            } else {
                dVar.l = 4;
            }
        }
    }
}

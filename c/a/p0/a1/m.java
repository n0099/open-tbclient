package c.a.p0.a1;

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
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.FaceBuyData;
import com.baidu.tieba.faceshop.FaceBuyModel;
import com.baidu.tieba.faceshop.FaceBuyWebViewActivity;
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
/* loaded from: classes2.dex */
public class m extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public static int k;
    public transient /* synthetic */ FieldHolder $fh;
    public FaceShopData a;

    /* renamed from: b  reason: collision with root package name */
    public final FaceShopActivity f11988b;

    /* renamed from: c  reason: collision with root package name */
    public final int f11989c;

    /* renamed from: d  reason: collision with root package name */
    public final int f11990d;

    /* renamed from: e  reason: collision with root package name */
    public final int f11991e;

    /* renamed from: f  reason: collision with root package name */
    public final int f11992f;

    /* renamed from: g  reason: collision with root package name */
    public int f11993g;

    /* renamed from: h  reason: collision with root package name */
    public FacePackageDownloadModel f11994h;
    public FaceBuyModel i;
    public View.OnClickListener j;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m a;

        public a(m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mVar;
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
                    int i = eVar.a;
                    if (!TbadkCoreApplication.isLogin()) {
                        this.a.f11993g = eVar.a;
                        TbadkCoreApplication.getInst().login(null, new CustomMessage<>(2002001, new LoginActivityConfig(this.a.f11988b.getPageContext().getPageActivity(), true, 11003)));
                        return;
                    }
                    int i2 = eVar.f12005b;
                    if (i2 == 2) {
                        this.a.i(i);
                    } else if (i2 == 3) {
                        this.a.j(i);
                    } else if (i2 != 4) {
                    } else {
                        this.a.g(i);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends c.a.d.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FacePackageData a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ m f11995b;

        public b(m mVar, FacePackageData facePackageData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar, facePackageData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11995b = mVar;
            this.a = facePackageData;
        }

        @Override // c.a.d.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (obj == null || !(obj instanceof FacePackageDownloadData)) {
                    UtilHelper.showToast(this.f11995b.f11988b.getPageContext().getContext(), (int) R.string.obfuscated_res_0x7f0f0c15);
                    return;
                }
                FacePackageDownloadData facePackageDownloadData = (FacePackageDownloadData) obj;
                if (facePackageDownloadData.errno == 0 && facePackageDownloadData.usermsg != null) {
                    this.a.pack_url = facePackageDownloadData.pack_url;
                    f f2 = f.f();
                    String valueOf = String.valueOf(this.a.pid);
                    FacePackageData facePackageData = this.a;
                    f2.j(valueOf, facePackageData.pname, facePackageData.pack_url);
                } else if (facePackageDownloadData.usermsg != null) {
                    UtilHelper.showToast(this.f11995b.f11988b.getPageContext().getContext(), facePackageDownloadData.usermsg);
                } else {
                    UtilHelper.showToast(this.f11995b.f11988b.getPageContext().getContext(), (int) R.string.obfuscated_res_0x7f0f0c15);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c extends c.a.d.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FacePackageData a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f11996b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ m f11997c;

        public c(m mVar, FacePackageData facePackageData, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar, facePackageData, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11997c = mVar;
            this.a = facePackageData;
            this.f11996b = i;
        }

        @Override // c.a.d.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                this.f11997c.f11988b.hideProgressBar();
                if (obj == null || !(obj instanceof FaceBuyData)) {
                    UtilHelper.showToast(this.f11997c.f11988b.getPageContext().getContext(), (int) R.string.obfuscated_res_0x7f0f0c15);
                    return;
                }
                FaceBuyData faceBuyData = (FaceBuyData) obj;
                if (faceBuyData.errno == 0 && faceBuyData.usermsg != null) {
                    FaceBuyData.BuyInfo buyInfo = faceBuyData.buy_info;
                    String str = buyInfo.buy_url;
                    String str2 = buyInfo.return_url;
                    if (buyInfo.buy_status == 2) {
                        UtilHelper.showToast(this.f11997c.f11988b.getPageContext().getContext(), (int) R.string.obfuscated_res_0x7f0f0806);
                        FacePackageData facePackageData = this.a;
                        facePackageData.buy_status = 1;
                        facePackageData.can_download = 1;
                        this.f11997c.notifyDataSetChanged();
                        return;
                    }
                    this.a.orderId = buyInfo.order_id;
                    IntentConfig intentConfig = new IntentConfig(this.f11997c.f11988b);
                    intentConfig.getIntent().putExtra("tag_url", str);
                    intentConfig.getIntent().putExtra(FaceBuyWebViewActivity.TAG_HOOK_URL, str2);
                    intentConfig.getIntent().putExtra("tag_title", this.f11997c.f11988b.getString(R.string.obfuscated_res_0x7f0f0344));
                    intentConfig.getIntent().putExtra(FaceBuyWebViewActivity.TAG_POSITION, this.f11996b);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2902013, intentConfig));
                } else if (faceBuyData.usermsg != null) {
                    UtilHelper.showToast(this.f11997c.f11988b.getPageContext().getContext(), faceBuyData.usermsg);
                } else {
                    UtilHelper.showToast(this.f11997c.f11988b.getPageContext().getContext(), (int) R.string.obfuscated_res_0x7f0f0c15);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbImageView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f11998b;

        /* renamed from: c  reason: collision with root package name */
        public FrameLayout f11999c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f12000d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f12001e;

        /* renamed from: f  reason: collision with root package name */
        public ImageView f12002f;

        /* renamed from: g  reason: collision with root package name */
        public FrameLayout f12003g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f12004h;
        public TbImageView i;
        public TbImageView j;
        public String k;
        public int l;
        public int m;

        public d(m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ d(m mVar, a aVar) {
            this(mVar);
        }
    }

    /* loaded from: classes2.dex */
    public class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f12005b;

        public e(m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ e(m mVar, a aVar) {
            this(mVar);
        }
    }

    public m(FaceShopActivity faceShopActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {faceShopActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f11993g = -1;
        this.j = new a(this);
        this.f11988b = faceShopActivity;
        int k2 = c.a.d.f.p.n.k(faceShopActivity.getPageContext().getPageActivity());
        k = k2;
        int dimensionPixelSize = k2 - (faceShopActivity.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070270) * 2);
        this.f11989c = dimensionPixelSize;
        this.f11990d = (int) (dimensionPixelSize * 0.38495576f);
        Bitmap resBitmap = BitmapHelper.getResBitmap(this.f11988b.getPageContext().getContext(), R.drawable.bg_content_download_down);
        if (resBitmap != null) {
            this.f11991e = resBitmap.getWidth();
        } else {
            this.f11991e = 0;
        }
        Bitmap resBitmap2 = BitmapHelper.getResBitmap(this.f11988b.getPageContext().getContext(), R.drawable.bg_content_download_up);
        if (resBitmap2 != null) {
            this.f11992f = resBitmap2.getWidth();
        } else {
            this.f11992f = 0;
        }
        this.f11994h = null;
        this.i = null;
    }

    public View c(int i, ViewGroup viewGroup) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, viewGroup)) == null) {
            if (i == 1) {
                d dVar = new d(this, null);
                View inflate = LayoutInflater.from(this.f11988b.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0290, (ViewGroup) null);
                dVar.f11998b = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09202b);
                dVar.a = (TbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090e69);
                dVar.f11999c = (FrameLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0903f9);
                dVar.f12000d = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090439);
                dVar.f12001e = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09082e);
                dVar.f12003g = (FrameLayout) inflate.findViewById(R.id.obfuscated_res_0x7f09082f);
                dVar.f12002f = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090830);
                dVar.f12004h = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090f47);
                TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090e06);
                dVar.i = tbImageView;
                tbImageView.setDefaultResource(0);
                dVar.i.setDefaultBgResource(0);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f11989c, this.f11990d);
                layoutParams.setMargins(0, 0, 0, this.f11988b.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702fb));
                dVar.a.setLayoutParams(layoutParams);
                dVar.f12000d.setClickable(false);
                dVar.f11999c.setClickable(true);
                dVar.f11999c.setOnClickListener(this.j);
                dVar.j = (TbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f092057);
                inflate.setTag(dVar);
                return inflate;
            }
            return null;
        }
        return (View) invokeIL.objValue;
    }

    public final void d(int i, d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, dVar) == null) || this.a == null || dVar == null) {
            return;
        }
        try {
            FacePackageData facePackageData = (FacePackageData) getItem(i);
            if (facePackageData == null) {
                return;
            }
            dVar.m = i;
            dVar.f11998b.setText(facePackageData.pname);
            dVar.f12004h.setText(facePackageData.pdesc);
            dVar.a.setTag(facePackageData.banner_url);
            dVar.a.G(facePackageData.banner_url, 10, this.f11989c, this.f11990d, false);
            if (facePackageData.new_icon != null && facePackageData.new_icon.length() > 0) {
                dVar.i.setTag(facePackageData.new_icon);
                dVar.i.J(facePackageData.new_icon, 21, false);
                dVar.i.setVisibility(0);
            } else {
                dVar.i.setVisibility(8);
            }
            dVar.k = facePackageData.price;
            r(facePackageData, dVar);
            e eVar = new e(this, null);
            eVar.f12005b = dVar.l;
            eVar.a = i;
            dVar.f11999c.setTag(eVar);
            if (!TextUtils.isEmpty(facePackageData.tag_url)) {
                dVar.j.setVisibility(0);
                dVar.j.setTag(facePackageData.tag_url);
                dVar.j.J(facePackageData.tag_url, 21, false);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f11993g : invokeV.intValue;
    }

    public final void f(d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) || dVar == null) {
            return;
        }
        dVar.f12000d.setVisibility(8);
        dVar.f11999c.setVisibility(8);
        dVar.f12001e.setVisibility(8);
        dVar.f12003g.setVisibility(8);
    }

    public void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            TiebaStatic.log("emotion_package_list_buy");
            FacePackageData facePackageData = (FacePackageData) getItem(i);
            if (this.a == null) {
                return;
            }
            this.f11988b.showProgressBar();
            String valueOf = String.valueOf(facePackageData.pid);
            FaceBuyModel faceBuyModel = new FaceBuyModel(this.f11988b.getPageContext().getContext());
            this.i = faceBuyModel;
            faceBuyModel.setLoadDataCallBack(new c(this, facePackageData, i));
            this.i.F(valueOf);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        ArrayList<FacePackageData> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            FaceShopData faceShopData = this.a;
            if (faceShopData == null || (arrayList = faceShopData.pack_list) == null) {
                return 0;
            }
            return arrayList.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        ArrayList<FacePackageData> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            FaceShopData faceShopData = this.a;
            if (faceShopData == null || (arrayList = faceShopData.pack_list) == null || i < 0 || i >= arrayList.size()) {
                return null;
            }
            return arrayList.get(i);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        ArrayList<FacePackageData> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            FaceShopData faceShopData = this.a;
            return (faceShopData == null || (arrayList = faceShopData.pack_list) == null || arrayList.get(i) == null) ? 2 : 1;
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048585, this, i, view, viewGroup)) == null) {
            int itemViewType = getItemViewType(i);
            int skinType = TbadkApplication.getInst().getSkinType();
            if (view == null) {
                view = c(itemViewType, viewGroup);
            }
            d dVar = (d) view.getTag();
            c.a.o0.r.c layoutMode = this.f11988b.getLayoutMode();
            layoutMode.k(skinType == 1);
            layoutMode.j(view);
            d(i, dVar);
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
            FaceBuyModel faceBuyModel = this.i;
            if (faceBuyModel != null) {
                faceBuyModel.cancelLoadData();
            }
            FacePackageDownloadModel facePackageDownloadModel = this.f11994h;
            if (facePackageDownloadModel != null) {
                facePackageDownloadModel.cancelLoadData();
            }
        }
    }

    public void i(int i) {
        FacePackageData facePackageData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i) == null) || (facePackageData = (FacePackageData) getItem(i)) == null) {
            return;
        }
        facePackageData.downloading = 1;
        notifyDataSetChanged();
        FacePackageDownloadModel facePackageDownloadModel = new FacePackageDownloadModel(this.f11988b.getPageContext().getContext());
        this.f11994h = facePackageDownloadModel;
        facePackageDownloadModel.F(String.valueOf(facePackageData.pid));
        this.f11994h.setLoadDataCallBack(new b(this, facePackageData));
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            TiebaStatic.log("emotion_package_list_free");
            FacePackageData facePackageData = (FacePackageData) getItem(i);
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
        int i = dVar.l;
        if (i == 1) {
            dVar.f12001e.setVisibility(0);
        } else if (i == 2 || i == 3 || i == 4) {
            dVar.f11999c.setVisibility(0);
            dVar.f12000d.setVisibility(0);
        } else if (i != 5) {
        } else {
            dVar.f12003g.setVisibility(0);
        }
    }

    public final void l(d dVar, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048591, this, dVar, i) == null) || dVar == null) {
            return;
        }
        int i2 = dVar.l;
        if (i2 == 5) {
            p(dVar, i);
        } else if (i2 == 2) {
            o(dVar, i);
        } else if (i2 == 3) {
            q(dVar, i);
        } else if (i2 != 4) {
        } else {
            m(dVar, i);
        }
    }

    public final void m(d dVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048592, this, dVar, i) == null) {
            dVar.f12000d.setText(dVar.k);
            dVar.f12000d.setBackgroundResource(0);
            SkinManager.setBackgroundResource(dVar.f11999c, R.drawable.faceshop_list_btn_selector);
        }
    }

    public void n(FaceShopData faceShopData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, faceShopData) == null) {
            this.a = faceShopData;
            notifyDataSetChanged();
        }
    }

    public final void o(d dVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048594, this, dVar, i) == null) {
            dVar.f12000d.setText((CharSequence) null);
            SkinManager.setBackgroundResource(dVar.f11999c, R.drawable.btn_all_blue);
            SkinManager.setBackgroundResource(dVar.f12000d, R.drawable.icon_content_download);
        }
    }

    public final void p(d dVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048595, this, dVar, i) == null) {
            f(dVar);
            dVar.f12003g.setVisibility(0);
            FacePackageData facePackageData = (FacePackageData) getItem(dVar.m);
            if (facePackageData == null) {
                return;
            }
            int i2 = (int) (this.f11991e * (((float) facePackageData.downloadNow) / ((float) facePackageData.downloadTotal)));
            int i3 = this.f11992f;
            if (i2 < i3) {
                i2 = i3;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) dVar.f12002f.getLayoutParams();
            layoutParams.width = i2;
            dVar.f12002f.setLayoutParams(layoutParams);
        }
    }

    public final void q(d dVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048596, this, dVar, i) == null) {
            dVar.f12000d.setText(dVar.k);
            dVar.f12000d.setBackgroundResource(0);
            SkinManager.setBackgroundResource(dVar.f11999c, R.drawable.btn_all_white);
        }
    }

    public final void r(FacePackageData facePackageData, d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048597, this, facePackageData, dVar) == null) || facePackageData == null || dVar == null) {
            return;
        }
        int i = facePackageData.buy_status;
        int i2 = facePackageData.can_download;
        int i3 = facePackageData.downloaded;
        if (facePackageData.downloading == 1) {
            dVar.l = 5;
        } else if (i3 == 1) {
            dVar.l = 1;
        } else if (i == 2) {
            dVar.l = 6;
        } else if (i == 1) {
            if (i2 == 1) {
                dVar.l = 2;
            }
        } else if (i == 0) {
            if (i2 == 1) {
                dVar.l = 3;
            } else {
                dVar.l = 4;
            }
        }
    }
}

package c.a.t0.i1.c;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.d.f.p.n;
import c.a.t0.i1.c.a;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.gift.myGiftList.MyGiftListActivity;
import com.baidu.tieba.wallet.CurrencySwitchUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class b extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f18366e;

    /* renamed from: f  reason: collision with root package name */
    public List<a.C1143a> f18367f;

    /* renamed from: g  reason: collision with root package name */
    public MyGiftListActivity f18368g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f18369h;

    /* renamed from: i  reason: collision with root package name */
    public NoDataView f18370i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f18371j;
    public int k;
    public View.OnClickListener l;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f18372e;

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
            this.f18372e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (l.z()) {
                    this.f18372e.f18368g.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(TbadkApplication.getInst().getContext(), String.valueOf((Long) view.getTag(R.id.tag_first)), (String) view.getTag(R.id.tag_second))));
                    return;
                }
                this.f18372e.f18368g.showToast(R.string.neterror);
            }
        }
    }

    /* renamed from: c.a.t0.i1.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C1144b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbImageView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f18373b;

        /* renamed from: c  reason: collision with root package name */
        public HeadImageView f18374c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f18375d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f18376e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f18377f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f18378g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f18379h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f18380i;

        public C1144b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ C1144b(a aVar) {
            this();
        }
    }

    public b(MyGiftListActivity myGiftListActivity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {myGiftListActivity, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f18366e = 1;
        this.f18369h = false;
        this.k = -1;
        this.l = new a(this);
        this.f18368g = myGiftListActivity;
        this.f18371j = z;
    }

    public final void b(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            this.f18368g.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
            this.f18368g.getLayoutMode().j(view);
        }
    }

    public final View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            NoDataViewFactory.c cVar = null;
            View inflate = LayoutInflater.from(this.f18368g.getPageContext().getPageActivity()).inflate(R.layout.buy_no_face_item, (ViewGroup) null);
            NoDataViewFactory.c a2 = NoDataViewFactory.c.a(new NoDataViewFactory.b(this.f18368g.getResources().getString(R.string.send_gift), this.f18368g.getSendGiftClickListener()));
            this.f18368g.getResources().getDimension(R.dimen.tbds200);
            this.f18368g.getResources().getDimension(R.dimen.ds140);
            String userSex = this.f18368g.getUserSex();
            this.f18368g.getPageContext().getString(R.string.no_gift);
            String string = this.f18368g.getPageContext().getString(R.string.come_on);
            String format = String.format(this.f18368g.getPageContext().getString(R.string.send_him_gift_note), userSex);
            Activity pageActivity = this.f18368g.getPageContext().getPageActivity();
            NoDataViewFactory.d a3 = NoDataViewFactory.d.a(NoDataViewFactory.ImgType.NODATA);
            if (!this.f18371j) {
                string = format;
            }
            NoDataViewFactory.e d2 = NoDataViewFactory.e.d(null, string);
            if (!this.f18371j && TbadkApplication.getInst().isGiftSwitchOn()) {
                cVar = a2;
            }
            this.f18370i = NoDataViewFactory.a(pageActivity, inflate, a3, d2, cVar);
            int skinType = TbadkApplication.getInst().getSkinType();
            this.f18368g.getLayoutMode().k(skinType == 1);
            this.f18368g.getLayoutMode().j(inflate);
            this.f18370i.onChangeSkinType(this.f18368g.getPageContext(), skinType);
            this.f18370i.setVisibility(0);
            return inflate;
        }
        return (View) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: d */
    public a.C1143a getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            if (this.f18369h) {
                return null;
            }
            int itemId = (int) getItemId(i2);
            List<a.C1143a> list = this.f18367f;
            if (list == null || list.size() == 0 || itemId < 0 || itemId >= this.f18367f.size()) {
                return null;
            }
            return this.f18367f.get(itemId);
        }
        return (a.C1143a) invokeI.objValue;
    }

    public void e(List<a.C1143a> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, list, i2) == null) {
            if (list != null && list.size() > 0) {
                this.f18369h = false;
            } else {
                this.f18369h = true;
            }
            this.f18367f = list;
            this.k = i2;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f18369h) {
                return 1;
            }
            List<a.C1143a> list = this.f18367f;
            if (list == null || list.size() == 0) {
                return 0;
            }
            return this.f18367f.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        C1144b c1144b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i2, view, viewGroup)) == null) {
            if (this.f18369h) {
                return c();
            }
            if (view != null && view.getTag(R.id.tag_first) != null) {
                c1144b = (C1144b) view.getTag(R.id.tag_first);
            } else {
                view = LayoutInflater.from(this.f18368g.getPageContext().getPageActivity()).inflate(R.layout.my_gift_list_item, viewGroup, false);
                c1144b = new C1144b(null);
                TbImageView tbImageView = (TbImageView) view.findViewById(R.id.item_rank_image);
                c1144b.a = tbImageView;
                tbImageView.setRadius(n.d(this.f18368g.getBaseContext(), 25.0f));
                c1144b.f18373b = (TextView) view.findViewById(R.id.item_rank_text);
                HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.item_portrait);
                c1144b.f18374c = headImageView;
                headImageView.setRadius(n.d(this.f18368g.getBaseContext(), 50.0f));
                c1144b.f18374c.setOnClickListener(this.l);
                c1144b.f18374c.setPlaceHolder(1);
                c1144b.f18375d = (TextView) view.findViewById(R.id.user_name);
                c1144b.f18379h = (TextView) view.findViewById(R.id.gift_num);
                c1144b.f18378g = (TextView) view.findViewById(R.id.gift_value_text);
                c1144b.f18377f = (TextView) view.findViewById(R.id.gift_name);
                c1144b.f18376e = (TextView) view.findViewById(R.id.time);
                c1144b.f18380i = (TextView) view.findViewById(R.id.paly_icon);
                view.setTag(R.id.tag_first, c1144b);
            }
            if (!this.f18371j) {
                c1144b.f18376e.setVisibility(8);
                c1144b.f18380i.setVisibility(8);
            } else {
                c1144b.f18380i.setVisibility(0);
            }
            a.C1143a item = getItem(i2);
            if (item != null) {
                if (this.f18368g.userType == 1) {
                    c1144b.f18374c.startLoad(item.f18356c, 12, false);
                    int i3 = item.f18361h;
                    if (i3 == 1) {
                        c1144b.a.setVisibility(0);
                        c1144b.a.setImageResource(R.drawable.icon_frs_no1);
                        c1144b.f18373b.setVisibility(8);
                    } else if (i3 == 2) {
                        c1144b.a.setVisibility(0);
                        c1144b.a.setImageResource(R.drawable.icon_frs_no2);
                        c1144b.f18373b.setVisibility(8);
                    } else if (i3 == 3) {
                        c1144b.a.setVisibility(0);
                        c1144b.a.setImageResource(R.drawable.icon_frs_no3);
                        c1144b.f18373b.setVisibility(8);
                    } else {
                        c1144b.a.setVisibility(8);
                        c1144b.f18373b.setVisibility(0);
                        TextView textView = c1144b.f18373b;
                        textView.setText(item.f18361h + "");
                    }
                } else {
                    c1144b.f18374c.startLoad(item.f18357d, 10, false);
                    c1144b.a.setVisibility(8);
                    c1144b.f18373b.setVisibility(8);
                }
                c1144b.f18374c.setDrawBorder(false);
                c1144b.f18375d.setText(TextUtils.isEmpty(item.f18362i) ? item.f18355b : item.f18362i);
                c1144b.f18374c.setTag(R.id.tag_first, Long.valueOf(item.a));
                c1144b.f18374c.setTag(R.id.tag_second, item.f18355b);
                c1144b.f18377f.setText(this.f18368g.getPageContext().getString(R.string.send_to_you));
                TextView textView2 = c1144b.f18378g;
                textView2.setText(this.f18368g.getPageContext().getString(R.string.gift_value) + item.f18360g);
                if (item.f18359f < 1) {
                    c1144b.f18379h.setVisibility(8);
                } else {
                    TextView textView3 = c1144b.f18379h;
                    textView3.setText(this.f18368g.getPageContext().getString(R.string.mutil_sign) + item.f18359f);
                    c1144b.f18379h.setVisibility(0);
                }
                String formatTime = StringHelper.getFormatTime(item.f18358e * 1000);
                c1144b.f18376e.setText(formatTime);
                if (CurrencySwitchUtil.isYyIsConvert(this.k)) {
                    c1144b.f18376e.setVisibility(8);
                    c1144b.f18378g.setText(formatTime);
                    SkinManager.setViewTextColor(c1144b.f18378g, R.color.CAM_X0109, 1);
                } else {
                    SkinManager.setViewTextColor(c1144b.f18378g, R.color.CAM_X0301, 1);
                }
            }
            b(view);
            return view;
        }
        return (View) invokeILL.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f18366e : invokeV.intValue;
    }
}

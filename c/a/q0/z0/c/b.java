package c.a.q0.z0.c;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.j;
import c.a.e.e.p.l;
import c.a.q0.z0.b.g;
import c.a.q0.z0.c.a;
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
/* loaded from: classes4.dex */
public class b extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f29276e;

    /* renamed from: f  reason: collision with root package name */
    public List<a.C1360a> f29277f;

    /* renamed from: g  reason: collision with root package name */
    public MyGiftListActivity f29278g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f29279h;

    /* renamed from: i  reason: collision with root package name */
    public NoDataView f29280i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f29281j;
    public int k;
    public View.OnClickListener l;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f29282e;

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
            this.f29282e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (j.z()) {
                    this.f29282e.f29278g.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(TbadkApplication.getInst().getContext(), String.valueOf((Long) view.getTag(R.id.tag_first)), (String) view.getTag(R.id.tag_second))));
                    return;
                }
                this.f29282e.f29278g.showToast(R.string.neterror);
            }
        }
    }

    /* renamed from: c.a.q0.z0.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1361b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f29283a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f29284b;

        /* renamed from: c  reason: collision with root package name */
        public HeadImageView f29285c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f29286d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f29287e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f29288f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f29289g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f29290h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f29291i;

        /* renamed from: j  reason: collision with root package name */
        public TextView f29292j;
        public TextView k;

        public C1361b() {
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

        public /* synthetic */ C1361b(a aVar) {
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
        this.f29276e = 1;
        this.f29279h = false;
        this.k = -1;
        this.l = new a(this);
        this.f29278g = myGiftListActivity;
        this.f29281j = z;
    }

    public final void b(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            this.f29278g.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
            this.f29278g.getLayoutMode().j(view);
        }
    }

    public final View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            NoDataViewFactory.c cVar = null;
            View inflate = LayoutInflater.from(this.f29278g.getPageContext().getPageActivity()).inflate(R.layout.buy_no_face_item, (ViewGroup) null);
            NoDataViewFactory.c a2 = NoDataViewFactory.c.a(new NoDataViewFactory.b(this.f29278g.getResources().getString(R.string.send_gift), this.f29278g.getSendGiftClickListener()));
            this.f29278g.getResources().getDimension(R.dimen.tbds200);
            this.f29278g.getResources().getDimension(R.dimen.ds140);
            String userSex = this.f29278g.getUserSex();
            this.f29278g.getPageContext().getString(R.string.no_gift);
            String string = this.f29278g.getPageContext().getString(R.string.come_on);
            String format = String.format(this.f29278g.getPageContext().getString(R.string.send_him_gift_note), userSex);
            Activity pageActivity = this.f29278g.getPageContext().getPageActivity();
            NoDataViewFactory.d a3 = NoDataViewFactory.d.a(NoDataViewFactory.ImgType.NODATA);
            if (!this.f29281j) {
                string = format;
            }
            NoDataViewFactory.e d2 = NoDataViewFactory.e.d(null, string);
            if (!this.f29281j && TbadkApplication.getInst().isGiftSwitchOn()) {
                cVar = a2;
            }
            this.f29280i = NoDataViewFactory.a(pageActivity, inflate, a3, d2, cVar);
            int skinType = TbadkApplication.getInst().getSkinType();
            this.f29278g.getLayoutMode().k(skinType == 1);
            this.f29278g.getLayoutMode().j(inflate);
            this.f29280i.onChangeSkinType(this.f29278g.getPageContext(), skinType);
            this.f29280i.setVisibility(0);
            return inflate;
        }
        return (View) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: d */
    public a.C1360a getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            if (this.f29279h) {
                return null;
            }
            int itemId = (int) getItemId(i2);
            List<a.C1360a> list = this.f29277f;
            if (list == null || list.size() == 0 || itemId < 0 || itemId >= this.f29277f.size()) {
                return null;
            }
            return this.f29277f.get(itemId);
        }
        return (a.C1360a) invokeI.objValue;
    }

    public void e(List<a.C1360a> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, list, i2) == null) {
            if (list != null && list.size() > 0) {
                this.f29279h = false;
            } else {
                this.f29279h = true;
            }
            this.f29277f = list;
            this.k = i2;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f29279h) {
                return 1;
            }
            List<a.C1360a> list = this.f29277f;
            if (list == null || list.size() == 0) {
                return 0;
            }
            return this.f29277f.size();
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
        C1361b c1361b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i2, view, viewGroup)) == null) {
            if (this.f29279h) {
                return c();
            }
            if (view != null && view.getTag(R.id.tag_first) != null) {
                c1361b = (C1361b) view.getTag(R.id.tag_first);
            } else {
                view = LayoutInflater.from(this.f29278g.getPageContext().getPageActivity()).inflate(R.layout.my_gift_list_item, viewGroup, false);
                c1361b = new C1361b(null);
                TbImageView tbImageView = (TbImageView) view.findViewById(R.id.item_rank_image);
                c1361b.f29283a = tbImageView;
                tbImageView.setRadius(l.e(this.f29278g.getBaseContext(), 25.0f));
                c1361b.f29284b = (TextView) view.findViewById(R.id.item_rank_text);
                HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.item_portrait);
                c1361b.f29285c = headImageView;
                headImageView.setRadius(l.e(this.f29278g.getBaseContext(), 50.0f));
                c1361b.f29285c.setOnClickListener(this.l);
                c1361b.f29285c.setPlaceHolder(1);
                c1361b.f29286d = (TextView) view.findViewById(R.id.user_name);
                c1361b.f29290h = (TextView) view.findViewById(R.id.gift_num);
                c1361b.f29289g = (TextView) view.findViewById(R.id.gift_value_text);
                c1361b.f29288f = (TextView) view.findViewById(R.id.gift_name);
                c1361b.f29287e = (TextView) view.findViewById(R.id.time);
                c1361b.f29291i = (TextView) view.findViewById(R.id.paly_icon);
                c1361b.f29292j = (TextView) view.findViewById(R.id.reward_prefix);
                c1361b.k = (TextView) view.findViewById(R.id.reward_num);
                view.setTag(R.id.tag_first, c1361b);
            }
            if (!this.f29281j) {
                c1361b.f29287e.setVisibility(8);
                c1361b.f29291i.setVisibility(8);
            } else {
                c1361b.f29291i.setVisibility(0);
            }
            a.C1360a item = getItem(i2);
            if (item != null) {
                if (this.f29278g.userType == 1) {
                    c1361b.f29285c.startLoad(item.f29263c, 12, false);
                    int i3 = item.f29270j;
                    if (i3 == 1) {
                        c1361b.f29283a.setVisibility(0);
                        c1361b.f29283a.setImageResource(R.drawable.icon_frs_no1);
                        c1361b.f29284b.setVisibility(8);
                    } else if (i3 == 2) {
                        c1361b.f29283a.setVisibility(0);
                        c1361b.f29283a.setImageResource(R.drawable.icon_frs_no2);
                        c1361b.f29284b.setVisibility(8);
                    } else if (i3 == 3) {
                        c1361b.f29283a.setVisibility(0);
                        c1361b.f29283a.setImageResource(R.drawable.icon_frs_no3);
                        c1361b.f29284b.setVisibility(8);
                    } else {
                        c1361b.f29283a.setVisibility(8);
                        c1361b.f29284b.setVisibility(0);
                        TextView textView = c1361b.f29284b;
                        textView.setText(item.f29270j + "");
                    }
                } else {
                    c1361b.f29285c.startLoad(item.f29264d, 10, false);
                    c1361b.f29283a.setVisibility(8);
                    c1361b.f29284b.setVisibility(8);
                }
                c1361b.f29285c.setDrawBorder(false);
                c1361b.f29286d.setText(TextUtils.isEmpty(item.k) ? item.f29262b : item.k);
                c1361b.f29285c.setTag(R.id.tag_first, Long.valueOf(item.f29261a));
                c1361b.f29285c.setTag(R.id.tag_second, item.f29262b);
                c1361b.f29288f.setText(this.f29278g.getPageContext().getString(R.string.send_to_you));
                TextView textView2 = c1361b.f29289g;
                textView2.setText(this.f29278g.getPageContext().getString(R.string.gift_value) + item.f29267g);
                if (item.f29266f < 1) {
                    c1361b.f29290h.setVisibility(8);
                } else {
                    TextView textView3 = c1361b.f29290h;
                    textView3.setText(this.f29278g.getPageContext().getString(R.string.mutil_sign) + item.f29266f);
                    c1361b.f29290h.setVisibility(0);
                }
                String formatTime = StringHelper.getFormatTime(item.f29265e * 1000);
                c1361b.f29287e.setText(formatTime);
                if (CurrencySwitchUtil.isYyIsConvert(this.k)) {
                    c1361b.f29287e.setVisibility(8);
                    c1361b.f29289g.setText(formatTime);
                    SkinManager.setViewTextColor(c1361b.f29289g, R.color.CAM_X0109, 1);
                } else {
                    SkinManager.setViewTextColor(c1361b.f29289g, R.color.CAM_X0301, 1);
                }
                c1361b.f29292j.setVisibility(0);
                c1361b.k.setVisibility(0);
                if (item.f29268h > 0) {
                    if (Integer.parseInt(item.f29269i) == 1) {
                        c1361b.k.setText(g.a(item.f29268h, 1, this.k));
                    } else if (Integer.parseInt(item.f29269i) == 2) {
                        c1361b.k.setText(g.a(item.f29268h, 2, this.k));
                    } else {
                        c1361b.f29292j.setVisibility(8);
                        c1361b.k.setVisibility(8);
                    }
                } else {
                    c1361b.f29292j.setVisibility(8);
                    c1361b.k.setVisibility(8);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f29276e : invokeV.intValue;
    }
}

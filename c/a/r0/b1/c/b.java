package c.a.r0.b1.c;

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
import c.a.r0.b1.b.g;
import c.a.r0.b1.c.a;
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
/* loaded from: classes3.dex */
public class b extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f15931e;

    /* renamed from: f  reason: collision with root package name */
    public List<a.C0759a> f15932f;

    /* renamed from: g  reason: collision with root package name */
    public MyGiftListActivity f15933g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f15934h;

    /* renamed from: i  reason: collision with root package name */
    public NoDataView f15935i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f15936j;
    public int k;
    public View.OnClickListener l;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f15937e;

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
            this.f15937e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (j.z()) {
                    this.f15937e.f15933g.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(TbadkApplication.getInst().getContext(), String.valueOf((Long) view.getTag(R.id.tag_first)), (String) view.getTag(R.id.tag_second))));
                    return;
                }
                this.f15937e.f15933g.showToast(R.string.neterror);
            }
        }
    }

    /* renamed from: c.a.r0.b1.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0760b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f15938a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f15939b;

        /* renamed from: c  reason: collision with root package name */
        public HeadImageView f15940c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f15941d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f15942e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f15943f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f15944g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f15945h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f15946i;

        /* renamed from: j  reason: collision with root package name */
        public TextView f15947j;
        public TextView k;

        public C0760b() {
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

        public /* synthetic */ C0760b(a aVar) {
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
        this.f15931e = 1;
        this.f15934h = false;
        this.k = -1;
        this.l = new a(this);
        this.f15933g = myGiftListActivity;
        this.f15936j = z;
    }

    public final void b(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            this.f15933g.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
            this.f15933g.getLayoutMode().j(view);
        }
    }

    public final View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            NoDataViewFactory.c cVar = null;
            View inflate = LayoutInflater.from(this.f15933g.getPageContext().getPageActivity()).inflate(R.layout.buy_no_face_item, (ViewGroup) null);
            NoDataViewFactory.c a2 = NoDataViewFactory.c.a(new NoDataViewFactory.b(this.f15933g.getResources().getString(R.string.send_gift), this.f15933g.getSendGiftClickListener()));
            this.f15933g.getResources().getDimension(R.dimen.tbds200);
            this.f15933g.getResources().getDimension(R.dimen.ds140);
            String userSex = this.f15933g.getUserSex();
            this.f15933g.getPageContext().getString(R.string.no_gift);
            String string = this.f15933g.getPageContext().getString(R.string.come_on);
            String format = String.format(this.f15933g.getPageContext().getString(R.string.send_him_gift_note), userSex);
            Activity pageActivity = this.f15933g.getPageContext().getPageActivity();
            NoDataViewFactory.d a3 = NoDataViewFactory.d.a(NoDataViewFactory.ImgType.NODATA);
            if (!this.f15936j) {
                string = format;
            }
            NoDataViewFactory.e d2 = NoDataViewFactory.e.d(null, string);
            if (!this.f15936j && TbadkApplication.getInst().isGiftSwitchOn()) {
                cVar = a2;
            }
            this.f15935i = NoDataViewFactory.a(pageActivity, inflate, a3, d2, cVar);
            int skinType = TbadkApplication.getInst().getSkinType();
            this.f15933g.getLayoutMode().k(skinType == 1);
            this.f15933g.getLayoutMode().j(inflate);
            this.f15935i.onChangeSkinType(this.f15933g.getPageContext(), skinType);
            this.f15935i.setVisibility(0);
            return inflate;
        }
        return (View) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: d */
    public a.C0759a getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            if (this.f15934h) {
                return null;
            }
            int itemId = (int) getItemId(i2);
            List<a.C0759a> list = this.f15932f;
            if (list == null || list.size() == 0 || itemId < 0 || itemId >= this.f15932f.size()) {
                return null;
            }
            return this.f15932f.get(itemId);
        }
        return (a.C0759a) invokeI.objValue;
    }

    public void e(List<a.C0759a> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, list, i2) == null) {
            if (list != null && list.size() > 0) {
                this.f15934h = false;
            } else {
                this.f15934h = true;
            }
            this.f15932f = list;
            this.k = i2;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f15934h) {
                return 1;
            }
            List<a.C0759a> list = this.f15932f;
            if (list == null || list.size() == 0) {
                return 0;
            }
            return this.f15932f.size();
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
        C0760b c0760b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i2, view, viewGroup)) == null) {
            if (this.f15934h) {
                return c();
            }
            if (view != null && view.getTag(R.id.tag_first) != null) {
                c0760b = (C0760b) view.getTag(R.id.tag_first);
            } else {
                view = LayoutInflater.from(this.f15933g.getPageContext().getPageActivity()).inflate(R.layout.my_gift_list_item, viewGroup, false);
                c0760b = new C0760b(null);
                TbImageView tbImageView = (TbImageView) view.findViewById(R.id.item_rank_image);
                c0760b.f15938a = tbImageView;
                tbImageView.setRadius(l.e(this.f15933g.getBaseContext(), 25.0f));
                c0760b.f15939b = (TextView) view.findViewById(R.id.item_rank_text);
                HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.item_portrait);
                c0760b.f15940c = headImageView;
                headImageView.setRadius(l.e(this.f15933g.getBaseContext(), 50.0f));
                c0760b.f15940c.setOnClickListener(this.l);
                c0760b.f15940c.setPlaceHolder(1);
                c0760b.f15941d = (TextView) view.findViewById(R.id.user_name);
                c0760b.f15945h = (TextView) view.findViewById(R.id.gift_num);
                c0760b.f15944g = (TextView) view.findViewById(R.id.gift_value_text);
                c0760b.f15943f = (TextView) view.findViewById(R.id.gift_name);
                c0760b.f15942e = (TextView) view.findViewById(R.id.time);
                c0760b.f15946i = (TextView) view.findViewById(R.id.paly_icon);
                c0760b.f15947j = (TextView) view.findViewById(R.id.reward_prefix);
                c0760b.k = (TextView) view.findViewById(R.id.reward_num);
                view.setTag(R.id.tag_first, c0760b);
            }
            if (!this.f15936j) {
                c0760b.f15942e.setVisibility(8);
                c0760b.f15946i.setVisibility(8);
            } else {
                c0760b.f15946i.setVisibility(0);
            }
            a.C0759a item = getItem(i2);
            if (item != null) {
                if (this.f15933g.userType == 1) {
                    c0760b.f15940c.startLoad(item.f15918c, 12, false);
                    int i3 = item.f15925j;
                    if (i3 == 1) {
                        c0760b.f15938a.setVisibility(0);
                        c0760b.f15938a.setImageResource(R.drawable.icon_frs_no1);
                        c0760b.f15939b.setVisibility(8);
                    } else if (i3 == 2) {
                        c0760b.f15938a.setVisibility(0);
                        c0760b.f15938a.setImageResource(R.drawable.icon_frs_no2);
                        c0760b.f15939b.setVisibility(8);
                    } else if (i3 == 3) {
                        c0760b.f15938a.setVisibility(0);
                        c0760b.f15938a.setImageResource(R.drawable.icon_frs_no3);
                        c0760b.f15939b.setVisibility(8);
                    } else {
                        c0760b.f15938a.setVisibility(8);
                        c0760b.f15939b.setVisibility(0);
                        TextView textView = c0760b.f15939b;
                        textView.setText(item.f15925j + "");
                    }
                } else {
                    c0760b.f15940c.startLoad(item.f15919d, 10, false);
                    c0760b.f15938a.setVisibility(8);
                    c0760b.f15939b.setVisibility(8);
                }
                c0760b.f15940c.setDrawBorder(false);
                c0760b.f15941d.setText(TextUtils.isEmpty(item.k) ? item.f15917b : item.k);
                c0760b.f15940c.setTag(R.id.tag_first, Long.valueOf(item.f15916a));
                c0760b.f15940c.setTag(R.id.tag_second, item.f15917b);
                c0760b.f15943f.setText(this.f15933g.getPageContext().getString(R.string.send_to_you));
                TextView textView2 = c0760b.f15944g;
                textView2.setText(this.f15933g.getPageContext().getString(R.string.gift_value) + item.f15922g);
                if (item.f15921f < 1) {
                    c0760b.f15945h.setVisibility(8);
                } else {
                    TextView textView3 = c0760b.f15945h;
                    textView3.setText(this.f15933g.getPageContext().getString(R.string.mutil_sign) + item.f15921f);
                    c0760b.f15945h.setVisibility(0);
                }
                String formatTime = StringHelper.getFormatTime(item.f15920e * 1000);
                c0760b.f15942e.setText(formatTime);
                if (CurrencySwitchUtil.isYyIsConvert(this.k)) {
                    c0760b.f15942e.setVisibility(8);
                    c0760b.f15944g.setText(formatTime);
                    SkinManager.setViewTextColor(c0760b.f15944g, R.color.CAM_X0109, 1);
                } else {
                    SkinManager.setViewTextColor(c0760b.f15944g, R.color.CAM_X0301, 1);
                }
                c0760b.f15947j.setVisibility(0);
                c0760b.k.setVisibility(0);
                if (item.f15923h > 0) {
                    if (Integer.parseInt(item.f15924i) == 1) {
                        c0760b.k.setText(g.a(item.f15923h, 1, this.k));
                    } else if (Integer.parseInt(item.f15924i) == 2) {
                        c0760b.k.setText(g.a(item.f15923h, 2, this.k));
                    } else {
                        c0760b.f15947j.setVisibility(8);
                        c0760b.k.setVisibility(8);
                    }
                } else {
                    c0760b.f15947j.setVisibility(8);
                    c0760b.k.setVisibility(8);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f15931e : invokeV.intValue;
    }
}

package c.a.r0.g3.h;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.switchs.BarDetailForDirSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.square.data.ForumInfoData;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class b extends BaseAdapter implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f18691e;

    /* renamed from: f  reason: collision with root package name */
    public int f18692f;

    /* renamed from: g  reason: collision with root package name */
    public LikeModel f18693g;

    /* renamed from: h  reason: collision with root package name */
    public int f18694h;

    /* renamed from: i  reason: collision with root package name */
    public int f18695i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f18696j;
    public ForumDetailActivityConfig.FromType k;
    public ForumInfoData[] l;

    /* loaded from: classes3.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public BarImageView f18697a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f18698b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f18699c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f18700d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f18701e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f18702f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f18703g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f18704h;

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
    }

    public b(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f18692f = -1;
        this.f18694h = 0;
        this.f18695i = 0;
        this.f18696j = true;
        this.k = ForumDetailActivityConfig.FromType.BAR_DIR;
        this.f18691e = tbPageContext;
        this.f18695i = i2;
        this.l = new ForumInfoData[0];
    }

    public ForumInfoData[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.l : (ForumInfoData[]) invokeV.objValue;
    }

    public String b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            if (i2 >= 100000) {
                return String.valueOf(i2 / 10000) + this.f18691e.getString(R.string.member_count_unit);
            }
            return String.valueOf(i2);
        }
        return (String) invokeI.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            LikeModel likeModel = this.f18693g;
            if (likeModel == null) {
                return false;
            }
            return likeModel.K();
        }
        return invokeV.booleanValue;
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            notifyDataSetChanged();
        }
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f18694h = i2;
            notifyDataSetChanged();
        }
    }

    public void f(ForumInfoData[] forumInfoDataArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, forumInfoDataArr) == null) {
            this.l = forumInfoDataArr;
            if (forumInfoDataArr != null) {
                notifyDataSetChanged();
            }
        }
    }

    public void g(ForumDetailActivityConfig.FromType fromType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, fromType) == null) {
            this.k = fromType;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ForumInfoData[] forumInfoDataArr = this.l;
            if (forumInfoDataArr == null) {
                return 0;
            }
            int i2 = this.f18694h;
            return i2 <= forumInfoDataArr.length ? i2 : forumInfoDataArr.length;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            if (i2 > this.f18694h) {
                return null;
            }
            return this.l[i2];
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048586, this, i2, view, viewGroup)) == null) {
            if (view == null || view.getTag() == null) {
                view = View.inflate(this.f18691e.getContext(), R.layout.forum_list_forum_item, null);
                a aVar = new a(this);
                BarImageView barImageView = (BarImageView) view.findViewById(R.id.forum_avatar);
                aVar.f18697a = barImageView;
                barImageView.setGifIconSupport(false);
                aVar.f18700d = (TextView) view.findViewById(R.id.name);
                aVar.f18701e = (TextView) view.findViewById(R.id.member_count);
                aVar.f18702f = (TextView) view.findViewById(R.id.thread_count);
                aVar.f18703g = (TextView) view.findViewById(R.id.slogan);
                aVar.f18704h = (TextView) view.findViewById(R.id.like);
                aVar.f18698b = (TextView) view.findViewById(R.id.rank_badge);
                aVar.f18699c = (TextView) view.findViewById(R.id.rise_no);
                view.setTag(aVar);
            }
            View findViewById = view.findViewById(R.id.bd_list_top_divider);
            View findViewById2 = view.findViewById(R.id.bd_list_bottom_divider);
            SkinManager.setBackgroundColor(findViewById, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(findViewById2, R.color.CAM_X0204);
            if (i2 == 0) {
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
            }
            a aVar2 = (a) view.getTag();
            this.f18691e.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.f18691e.getLayoutMode().j(view);
            ForumInfoData[] forumInfoDataArr = this.l;
            ForumInfoData forumInfoData = forumInfoDataArr[i2];
            String str = forumInfoDataArr[i2].avatar;
            aVar2.f18697a.setTag(str);
            aVar2.f18697a.invalidate();
            aVar2.f18697a.startLoad(str, 10, false);
            aVar2.f18700d.setText(forumInfoData.forum_name);
            aVar2.f18700d.setTag(Integer.valueOf(forumInfoData.forum_id));
            aVar2.f18704h.setTag(forumInfoData.forum_name);
            TextView textView = aVar2.f18701e;
            textView.setText(this.f18691e.getString(R.string.attention) + " " + b(forumInfoData.member_count));
            TextView textView2 = aVar2.f18702f;
            textView2.setText(this.f18691e.getString(R.string.text_post) + " " + b(forumInfoData.thread_count));
            aVar2.f18703g.setText(forumInfoData.slogan);
            if (this.f18695i == 0) {
                aVar2.f18699c.setVisibility(8);
                if (!this.f18696j) {
                    aVar2.f18698b.setVisibility(8);
                } else {
                    aVar2.f18698b.setVisibility(0);
                    aVar2.f18698b.setText((CharSequence) null);
                    aVar2.f18698b.setBackgroundDrawable(null);
                    if (i2 == 0) {
                        SkinManager.setBackgroundResource(aVar2.f18698b, R.drawable.icon_brief_grade_orange);
                    } else if (i2 == 1) {
                        SkinManager.setBackgroundResource(aVar2.f18698b, R.drawable.icon_brief_grade_blue);
                    } else if (i2 != 2) {
                        aVar2.f18698b.setText(String.format("%02d", Integer.valueOf(i2 + 1)));
                    } else {
                        SkinManager.setBackgroundResource(aVar2.f18698b, R.drawable.icon_brief_grade_green);
                    }
                }
            } else {
                aVar2.f18698b.setVisibility(8);
                aVar2.f18699c.setVisibility(0);
                aVar2.f18699c.setText((CharSequence) null);
                aVar2.f18699c.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(R.drawable.icon_rise), (Drawable) null, (Drawable) null, (Drawable) null);
                TextView textView3 = aVar2.f18699c;
                textView3.setText(this.f18691e.getString(R.string.rise) + String.valueOf(forumInfoData.mbr_inter_rank) + this.f18691e.getString(R.string.number));
            }
            aVar2.f18704h.setOnClickListener(this);
            view.setOnClickListener(this);
            return view;
        }
        return (View) invokeILL.objValue;
    }

    public void h(Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bool) == null) {
            this.f18696j = bool.booleanValue();
        }
    }

    public void i(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048588, this, i2, i3) == null) || i2 == 0 || i3 == 0) {
            return;
        }
        notifyDataSetChanged();
    }

    public void j(LikeModel likeModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, likeModel) == null) {
            this.f18693g = likeModel;
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            for (int i2 = 0; i2 < this.f18694h; i2++) {
                int hasLikeForum = TbadkCoreApplication.getInst().hasLikeForum(this.l[i2].forum_name);
                if (hasLikeForum == 1) {
                    this.l[i2].is_like = 1;
                } else if (hasLikeForum == -1) {
                    this.l[i2].is_like = 0;
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, view) == null) {
            if (view.getId() == R.id.like) {
                TiebaStatic.eventStat(this.f18691e.getContext(), "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
                this.f18691e.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f18691e.getPageActivity()).createNormalCfg((String) view.getTag(), null).setCallFrom(5)));
                return;
            }
            a aVar = (a) view.getTag();
            if (TbadkCoreApplication.getInst().isRegistedIntent(ForumDetailActivityConfig.class) && SwitchManager.getInstance().findType(BarDetailForDirSwitch.BAR_DETAIL_DIR) == 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(this.f18691e.getPageActivity(), String.valueOf(aVar.f18700d.getTag()), this.k)));
                return;
            }
            TiebaStatic.eventStat(this.f18691e.getContext(), "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
            this.f18691e.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f18691e.getPageActivity()).createNormalCfg(aVar.f18700d.getText().toString(), null)));
        }
    }
}

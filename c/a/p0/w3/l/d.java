package c.a.p0.w3.l;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.record.VideoEffectLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public class d extends BaseAdapter implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<e> f28088e;

    /* renamed from: f  reason: collision with root package name */
    public String f28089f;

    /* renamed from: g  reason: collision with root package name */
    public int f28090g;

    /* renamed from: h  reason: collision with root package name */
    public VideoEffectLayout.h f28091h;

    /* loaded from: classes4.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f28092a;

        /* renamed from: b  reason: collision with root package name */
        public ProgressBar f28093b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f28094c;

        /* renamed from: d  reason: collision with root package name */
        public int f28095d;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
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

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f28090g = -1;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public e getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            List<e> list = this.f28088e;
            if (list != null && i2 >= 0 && i2 < list.size()) {
                return this.f28088e.get(i2);
            }
            return null;
        }
        return (e) invokeI.objValue;
    }

    public final void b(a aVar, View view, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, view, viewGroup) == null) {
            TbImageView tbImageView = (TbImageView) view.findViewById(R.id.iv_effect);
            aVar.f28092a = tbImageView;
            tbImageView.setIsRound(true);
            aVar.f28092a.setDrawerType(1);
            aVar.f28092a.setDefaultBgResource(R.color.transparent);
            aVar.f28092a.setBorderWidth(c.a.e.e.p.l.g(viewGroup.getContext(), R.dimen.ds4));
            aVar.f28092a.setConrers(15);
            aVar.f28092a.setBorderColor(SkinManager.getColor(R.color.CAM_X0302));
            aVar.f28094c = (TextView) view.findViewById(R.id.tv_name);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && getItem(2) != null && getItem(2).c() == 1) {
            this.f28090g = 0;
            this.f28089f = getItem(2).b();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && getItem(0) != null && getItem(0).c() == 2) {
            this.f28090g = 0;
            this.f28089f = getItem(0).b();
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && getItem(0) != null && getItem(0).c() == 3) {
            this.f28090g = 0;
            this.f28089f = TbadkCoreApplication.getInst().getString(R.string.music_normal);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && getItem(0) != null && getItem(0).c() == 3) {
            this.f28090g = 1;
            this.f28089f = TbadkCoreApplication.getInst().getString(R.string.music_cloud);
            notifyDataSetChanged();
        }
    }

    public void g(List<e> list, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, list, str) == null) {
            this.f28088e = list;
            this.f28089f = str;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            List<e> list = this.f28088e;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            e item = getItem(i2);
            if (item == null) {
                return 0;
            }
            int c2 = item.c();
            if (c2 != 1) {
                return c2 != 3 ? 0 : 1;
            }
            return 2;
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        a aVar;
        e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048587, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                aVar = new a(this);
                int itemViewType = getItemViewType(i2);
                if (itemViewType == 0) {
                    view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_effect, (ViewGroup) null);
                    b(aVar, view, viewGroup);
                    ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.iv_loading);
                    aVar.f28093b = progressBar;
                    progressBar.setVisibility(4);
                    SkinManager.setViewTextColor(aVar.f28094c, R.color.CAM_X0101);
                } else if (itemViewType == 1) {
                    view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_effect, (ViewGroup) null);
                    b(aVar, view, viewGroup);
                    aVar.f28093b = (ProgressBar) view.findViewById(R.id.iv_loading);
                    aVar.f28092a.setDefaultResource(R.drawable.bg_video_cloudmusic);
                    SkinManager.setViewTextColor(aVar.f28094c, R.color.CAM_X0101);
                } else if (itemViewType == 2) {
                    view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_beauty, (ViewGroup) null);
                    b(aVar, view, viewGroup);
                    SkinManager.setViewTextColor(aVar.f28094c, R.color.CAM_X0101);
                }
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            List<e> list = this.f28088e;
            if (list != null && i2 >= 0 && i2 <= list.size() - 1 && (eVar = this.f28088e.get(i2)) != null) {
                int itemViewType2 = getItemViewType(i2);
                if (itemViewType2 == 0) {
                    aVar.f28092a.startLoad(String.valueOf(eVar.a()), 24, false);
                    if (!TextUtils.isEmpty(eVar.b()) && eVar.b().equals(this.f28089f)) {
                        aVar.f28092a.setDrawBorder(true);
                    } else {
                        aVar.f28092a.setDrawBorder(false);
                    }
                } else if (itemViewType2 == 1) {
                    MusicData musicData = (MusicData) eVar.d();
                    if (musicData.editMusicType == 0) {
                        aVar.f28092a.startLoad(musicData.img, 10, false);
                    } else {
                        aVar.f28092a.startLoad(String.valueOf(eVar.a()), 24, false);
                    }
                    if (this.f28090g != i2) {
                        aVar.f28093b.setVisibility(4);
                    } else if (aVar.f28093b.getVisibility() == 0) {
                        aVar.f28092a.setDrawBorder(false);
                    }
                    if (!TextUtils.isEmpty(eVar.b()) && eVar.b().equals(this.f28089f)) {
                        aVar.f28092a.setDrawBorder(true);
                    } else {
                        aVar.f28092a.setDrawBorder(false);
                    }
                } else if (itemViewType2 == 2) {
                    if (!TextUtils.isEmpty(eVar.b()) && eVar.b().equals(this.f28089f)) {
                        aVar.f28092a.setBackgroundResource(R.drawable.bg_beauty_item_choosed);
                    } else {
                        aVar.f28092a.setBackgroundResource(R.drawable.bg_beauty_item);
                    }
                }
                aVar.f28092a.setTag(eVar);
                aVar.f28092a.setTag(R.id.record_video_effect_holder, aVar);
                aVar.f28092a.setOnClickListener(this);
                aVar.f28094c.setText(eVar.b());
                aVar.f28095d = i2;
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return 3;
        }
        return invokeV.intValue;
    }

    public void h(VideoEffectLayout.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, hVar) == null) {
            this.f28091h = hVar;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        VideoEffectLayout.h hVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, view) == null) && view.getId() == R.id.iv_effect && (view.getTag() instanceof e)) {
            e eVar = (e) view.getTag();
            if (eVar.c() == 3 && (eVar.d() instanceof MusicData)) {
                StatisticItem statisticItem = new StatisticItem("c12423");
                statisticItem.param("obj_id", ((MusicData) eVar.d()).id);
                statisticItem.param("obj_locate", this.f28088e.indexOf(eVar) + 1);
                statisticItem.param("obj_source", 1);
                TiebaStatic.log(statisticItem);
                if (view.getResources().getString(R.string.music_cloud).equals(eVar.b()) && (hVar = this.f28091h) != null) {
                    hVar.onEffectChoosed(eVar, view.getTag(R.id.record_video_effect_holder));
                    this.f28090g = this.f28088e.indexOf(eVar);
                    this.f28089f = eVar.b();
                }
                if (!TextUtils.isEmpty(eVar.b()) && eVar.b().equals(this.f28089f)) {
                    return;
                }
                if (!eVar.b().equals(view.getResources().getString(R.string.music_cloud))) {
                    this.f28090g = this.f28088e.indexOf(eVar);
                }
            } else {
                this.f28090g = this.f28088e.indexOf(eVar);
            }
            this.f28089f = eVar.b();
            notifyDataSetChanged();
            VideoEffectLayout.h hVar2 = this.f28091h;
            if (hVar2 != null) {
                hVar2.onEffectChoosed(eVar, view.getTag(R.id.record_video_effect_holder));
            }
        }
    }
}

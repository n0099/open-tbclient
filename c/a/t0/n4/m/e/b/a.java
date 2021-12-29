package c.a.t0.n4.m.e.b;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import c.a.d.f.p.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.data.QmFilterItem;
import com.baidu.tbadk.data.TbMusicData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.external.music.data.MusicData;
import com.baidu.tieba.view.widget.recordeffect.RecordEffectLayout;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class a extends BaseAdapter implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final int f20573i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<c.a.t0.n4.m.e.c.b> f20574e;

    /* renamed from: f  reason: collision with root package name */
    public String f20575f;

    /* renamed from: g  reason: collision with root package name */
    public int f20576g;

    /* renamed from: h  reason: collision with root package name */
    public RecordEffectLayout.i f20577h;

    /* renamed from: c.a.t0.n4.m.e.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1243a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbImageView a;

        /* renamed from: b  reason: collision with root package name */
        public ProgressBar f20578b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f20579c;

        /* renamed from: d  reason: collision with root package name */
        public int f20580d;

        public C1243a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
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

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-965938161, "Lc/a/t0/n4/m/e/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-965938161, "Lc/a/t0/n4/m/e/b/a;");
                return;
            }
        }
        f20573i = UtilHelper.getDimenPixelSize(R.dimen.tbds156);
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f20576g = -1;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public c.a.t0.n4.m.e.c.b getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            List<c.a.t0.n4.m.e.c.b> list = this.f20574e;
            if (list != null && i2 >= 0 && i2 < list.size()) {
                return this.f20574e.get(i2);
            }
            return null;
        }
        return (c.a.t0.n4.m.e.c.b) invokeI.objValue;
    }

    public final void b(C1243a c1243a, View view, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c1243a, view, viewGroup) == null) {
            TbImageView tbImageView = (TbImageView) view.findViewById(R.id.iv_effect);
            c1243a.a = tbImageView;
            tbImageView.setIsRound(true);
            c1243a.a.setDrawerType(1);
            c1243a.a.setDefaultBgResource(R.color.transparent);
            c1243a.a.setBorderWidth(n.f(viewGroup.getContext(), R.dimen.ds4));
            c1243a.a.setConrers(15);
            c1243a.a.setBorderColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0302));
            c1243a.f20579c = (TextView) view.findViewById(R.id.tv_name);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && getItem(2) != null && getItem(2).getType() == 1) {
            this.f20576g = 0;
            this.f20575f = getItem(2).b();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && getItem(0) != null && getItem(0).getType() == 2) {
            this.f20576g = 0;
            this.f20575f = ((QmFilterItem) getItem(0).c()).id;
            List<c.a.t0.n4.m.e.c.b> list = this.f20574e;
            if (list != null) {
                for (c.a.t0.n4.m.e.c.b bVar : list) {
                    QmFilterItem qmFilterItem = (QmFilterItem) bVar.c();
                    if ("-1".equals(qmFilterItem.id)) {
                        qmFilterItem.isSelect = true;
                    } else {
                        qmFilterItem.isSelect = false;
                        qmFilterItem.isDownLoading = false;
                    }
                }
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && getItem(0) != null && getItem(0).getType() == 3) {
            this.f20576g = 0;
            this.f20575f = TbadkCoreApplication.getInst().getString(R.string.music_normal);
        }
    }

    public void f(TbMusicData tbMusicData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, tbMusicData) == null) || getCount() <= 1 || getItem(1) == null || getItem(1).getType() != 3) {
            return;
        }
        this.f20576g = 1;
        this.f20575f = TbadkCoreApplication.getInst().getString(R.string.music_cloud);
        notifyDataSetChanged();
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f20575f = str;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            List<c.a.t0.n4.m.e.c.b> list = this.f20574e;
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
            c.a.t0.n4.m.e.c.b item = getItem(i2);
            if (item == null) {
                return 0;
            }
            int type = item.getType();
            if (type != 1) {
                return type != 3 ? 0 : 1;
            }
            return 2;
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        C1243a c1243a;
        View view2;
        c.a.t0.n4.m.e.c.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048587, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                c1243a = new C1243a(this);
                int itemViewType = getItemViewType(i2);
                if (itemViewType == 0) {
                    view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.capture_list_item_effect, (ViewGroup) null);
                    b(c1243a, view2, viewGroup);
                    c1243a.f20578b = (ProgressBar) view2.findViewById(R.id.iv_loading);
                    c1243a.f20579c.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0101));
                } else if (itemViewType == 1) {
                    view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.capture_list_item_effect, (ViewGroup) null);
                    b(c1243a, view2, viewGroup);
                    c1243a.f20578b = (ProgressBar) view2.findViewById(R.id.iv_loading);
                    c1243a.a.setDefaultResource(R.drawable.bg_video_cloudmusic);
                    c1243a.f20579c.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0101));
                } else if (itemViewType != 2) {
                    view2 = view;
                } else {
                    view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.capture_list_item_beauty, (ViewGroup) null);
                    b(c1243a, view2, viewGroup);
                    c1243a.f20579c.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0101));
                }
                view2.setTag(c1243a);
            } else {
                c1243a = (C1243a) view.getTag();
                view2 = view;
            }
            List<c.a.t0.n4.m.e.c.b> list = this.f20574e;
            if (list != null && i2 >= 0 && i2 <= list.size() - 1 && (bVar = this.f20574e.get(i2)) != null) {
                int itemViewType2 = getItemViewType(i2);
                if (itemViewType2 == 0) {
                    QmFilterItem qmFilterItem = (QmFilterItem) bVar.c();
                    if ("-1".equals(qmFilterItem.id)) {
                        TbImageView tbImageView = c1243a.a;
                        String str = qmFilterItem.bgurl;
                        int i3 = f20573i;
                        tbImageView.startLoad(str, 24, i3, i3, false);
                    } else {
                        TbImageView tbImageView2 = c1243a.a;
                        String str2 = qmFilterItem.bgurl;
                        int i4 = f20573i;
                        tbImageView2.startLoad(str2, 10, i4, i4, false);
                    }
                    if (!TextUtils.isEmpty(qmFilterItem.id) && qmFilterItem.id.equals(this.f20575f)) {
                        c1243a.a.setDrawBorder(true);
                    } else {
                        c1243a.a.setDrawBorder(false);
                    }
                    if (qmFilterItem.isDownLoading) {
                        c1243a.f20578b.setVisibility(0);
                    } else {
                        c1243a.f20578b.setVisibility(4);
                    }
                    if (this.f20576g != i2) {
                        c1243a.f20578b.setVisibility(4);
                    } else if (c1243a.f20578b.getVisibility() == 0) {
                        c1243a.a.setDrawBorder(false);
                    }
                    c1243a.f20579c.setText(bVar.b());
                } else if (itemViewType2 == 1) {
                    MusicData musicData = (MusicData) bVar.c();
                    int i5 = musicData.editMusicType;
                    if (i5 != 0 && (i5 != 2 || TextUtils.isEmpty(musicData.img))) {
                        TbImageView tbImageView3 = c1243a.a;
                        String valueOf = String.valueOf(bVar.a());
                        int i6 = f20573i;
                        tbImageView3.startLoad(valueOf, 24, i6, i6, false);
                    } else {
                        TbImageView tbImageView4 = c1243a.a;
                        String str3 = musicData.img;
                        int i7 = f20573i;
                        tbImageView4.startLoad(str3, 10, i7, i7, false);
                    }
                    if (!TextUtils.isEmpty(bVar.b()) && bVar.b().equals(this.f20575f)) {
                        c1243a.a.setDrawBorder(true);
                    } else {
                        c1243a.a.setDrawBorder(false);
                    }
                    if (this.f20576g != i2) {
                        c1243a.f20578b.setVisibility(4);
                    } else if (c1243a.f20578b.getVisibility() == 0) {
                        c1243a.a.setDrawBorder(false);
                    }
                    c1243a.f20579c.setText(musicData.name);
                } else if (itemViewType2 == 2) {
                    if (!TextUtils.isEmpty(bVar.b()) && bVar.b().equals(this.f20575f)) {
                        c1243a.a.setBackgroundResource(R.drawable.bg_beauty_item_choosed);
                    } else {
                        c1243a.a.setBackgroundResource(R.drawable.bg_beauty_item);
                    }
                    c1243a.f20579c.setText(bVar.b());
                }
                c1243a.a.setTag(bVar);
                c1243a.a.setTag(R.id.record_video_effect_holder, c1243a);
                c1243a.a.setOnClickListener(this);
                c1243a.f20580d = i2;
            }
            return view2;
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

    public void h(List<c.a.t0.n4.m.e.c.b> list, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, list, str) == null) {
            this.f20574e = list;
            this.f20575f = str;
        }
    }

    public void i(RecordEffectLayout.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, iVar) == null) {
            this.f20577h = iVar;
        }
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, str) == null) && getCount() > 1 && getItem(1) != null && getItem(1).getType() == 3 && (getItem(1).c() instanceof MusicData)) {
            ((MusicData) getItem(1).c()).img = str;
            notifyDataSetChanged();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        RecordEffectLayout.i iVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, view) == null) && view.getId() == R.id.iv_effect && (view.getTag() instanceof c.a.t0.n4.m.e.c.b)) {
            c.a.t0.n4.m.e.c.b bVar = (c.a.t0.n4.m.e.c.b) view.getTag();
            if (bVar.getType() == 3 && (bVar.c() instanceof MusicData)) {
                if (view.getResources().getString(R.string.music_cloud).equals(bVar.b()) && (iVar = this.f20577h) != null) {
                    iVar.b(bVar, view.getTag(R.id.record_video_effect_holder));
                    this.f20576g = this.f20574e.indexOf(bVar);
                    this.f20575f = bVar.b();
                }
                if (!TextUtils.isEmpty(bVar.b()) && bVar.b().equals(this.f20575f)) {
                    return;
                }
                if (!bVar.b().equals(view.getResources().getString(R.string.music_cloud))) {
                    this.f20576g = this.f20574e.indexOf(bVar);
                }
            } else {
                this.f20576g = this.f20574e.indexOf(bVar);
            }
            if (bVar.getType() == 2 && (bVar.c() instanceof QmFilterItem)) {
                this.f20575f = ((QmFilterItem) bVar.c()).id;
            } else {
                this.f20575f = bVar.b();
            }
            notifyDataSetChanged();
            RecordEffectLayout.i iVar2 = this.f20577h;
            if (iVar2 != null) {
                iVar2.b(bVar, view.getTag(R.id.record_video_effect_holder));
            }
        }
    }
}

package c.a.q0.a4.l.e.b;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import c.a.e.e.p.l;
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
/* loaded from: classes3.dex */
public class a extends BaseAdapter implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final int f15852i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<c.a.q0.a4.l.e.c.b> f15853e;

    /* renamed from: f  reason: collision with root package name */
    public String f15854f;

    /* renamed from: g  reason: collision with root package name */
    public int f15855g;

    /* renamed from: h  reason: collision with root package name */
    public RecordEffectLayout.i f15856h;

    /* renamed from: c.a.q0.a4.l.e.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0749a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f15857a;

        /* renamed from: b  reason: collision with root package name */
        public ProgressBar f15858b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f15859c;

        /* renamed from: d  reason: collision with root package name */
        public int f15860d;

        public C0749a(a aVar) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(693458566, "Lc/a/q0/a4/l/e/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(693458566, "Lc/a/q0/a4/l/e/b/a;");
                return;
            }
        }
        f15852i = UtilHelper.getDimenPixelSize(R.dimen.tbds156);
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
        this.f15855g = -1;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public c.a.q0.a4.l.e.c.b getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            List<c.a.q0.a4.l.e.c.b> list = this.f15853e;
            if (list != null && i2 >= 0 && i2 < list.size()) {
                return this.f15853e.get(i2);
            }
            return null;
        }
        return (c.a.q0.a4.l.e.c.b) invokeI.objValue;
    }

    public final void b(C0749a c0749a, View view, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c0749a, view, viewGroup) == null) {
            TbImageView tbImageView = (TbImageView) view.findViewById(R.id.iv_effect);
            c0749a.f15857a = tbImageView;
            tbImageView.setIsRound(true);
            c0749a.f15857a.setDrawerType(1);
            c0749a.f15857a.setDefaultBgResource(R.color.transparent);
            c0749a.f15857a.setBorderWidth(l.g(viewGroup.getContext(), R.dimen.ds4));
            c0749a.f15857a.setConrers(15);
            c0749a.f15857a.setBorderColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0302));
            c0749a.f15859c = (TextView) view.findViewById(R.id.tv_name);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && getItem(2) != null && getItem(2).c() == 1) {
            this.f15855g = 0;
            this.f15854f = getItem(2).b();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && getItem(0) != null && getItem(0).c() == 2) {
            this.f15855g = 0;
            this.f15854f = ((QmFilterItem) getItem(0).d()).id;
            List<c.a.q0.a4.l.e.c.b> list = this.f15853e;
            if (list != null) {
                for (c.a.q0.a4.l.e.c.b bVar : list) {
                    QmFilterItem qmFilterItem = (QmFilterItem) bVar.d();
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
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && getItem(0) != null && getItem(0).c() == 3) {
            this.f15855g = 0;
            this.f15854f = TbadkCoreApplication.getInst().getString(R.string.music_normal);
        }
    }

    public void f(TbMusicData tbMusicData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, tbMusicData) == null) || getCount() <= 1 || getItem(1) == null || getItem(1).c() != 3) {
            return;
        }
        this.f15855g = 1;
        this.f15854f = TbadkCoreApplication.getInst().getString(R.string.music_cloud);
        notifyDataSetChanged();
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f15854f = str;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            List<c.a.q0.a4.l.e.c.b> list = this.f15853e;
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
            c.a.q0.a4.l.e.c.b item = getItem(i2);
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
        C0749a c0749a;
        View view2;
        c.a.q0.a4.l.e.c.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048587, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                c0749a = new C0749a(this);
                int itemViewType = getItemViewType(i2);
                if (itemViewType == 0) {
                    view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.capture_list_item_effect, (ViewGroup) null);
                    b(c0749a, view2, viewGroup);
                    c0749a.f15858b = (ProgressBar) view2.findViewById(R.id.iv_loading);
                    c0749a.f15859c.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0101));
                } else if (itemViewType == 1) {
                    view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.capture_list_item_effect, (ViewGroup) null);
                    b(c0749a, view2, viewGroup);
                    c0749a.f15858b = (ProgressBar) view2.findViewById(R.id.iv_loading);
                    c0749a.f15857a.setDefaultResource(R.drawable.bg_video_cloudmusic);
                    c0749a.f15859c.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0101));
                } else if (itemViewType != 2) {
                    view2 = view;
                } else {
                    view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.capture_list_item_beauty, (ViewGroup) null);
                    b(c0749a, view2, viewGroup);
                    c0749a.f15859c.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0101));
                }
                view2.setTag(c0749a);
            } else {
                c0749a = (C0749a) view.getTag();
                view2 = view;
            }
            List<c.a.q0.a4.l.e.c.b> list = this.f15853e;
            if (list != null && i2 >= 0 && i2 <= list.size() - 1 && (bVar = this.f15853e.get(i2)) != null) {
                int itemViewType2 = getItemViewType(i2);
                if (itemViewType2 == 0) {
                    QmFilterItem qmFilterItem = (QmFilterItem) bVar.d();
                    if ("-1".equals(qmFilterItem.id)) {
                        TbImageView tbImageView = c0749a.f15857a;
                        String str = qmFilterItem.bgurl;
                        int i3 = f15852i;
                        tbImageView.startLoad(str, 24, i3, i3, false);
                    } else {
                        TbImageView tbImageView2 = c0749a.f15857a;
                        String str2 = qmFilterItem.bgurl;
                        int i4 = f15852i;
                        tbImageView2.startLoad(str2, 10, i4, i4, false);
                    }
                    if (!TextUtils.isEmpty(qmFilterItem.id) && qmFilterItem.id.equals(this.f15854f)) {
                        c0749a.f15857a.setDrawBorder(true);
                    } else {
                        c0749a.f15857a.setDrawBorder(false);
                    }
                    if (qmFilterItem.isDownLoading) {
                        c0749a.f15858b.setVisibility(0);
                    } else {
                        c0749a.f15858b.setVisibility(4);
                    }
                    if (this.f15855g != i2) {
                        c0749a.f15858b.setVisibility(4);
                    } else if (c0749a.f15858b.getVisibility() == 0) {
                        c0749a.f15857a.setDrawBorder(false);
                    }
                    c0749a.f15859c.setText(bVar.b());
                } else if (itemViewType2 == 1) {
                    MusicData musicData = (MusicData) bVar.d();
                    int i5 = musicData.editMusicType;
                    if (i5 != 0 && (i5 != 2 || TextUtils.isEmpty(musicData.img))) {
                        TbImageView tbImageView3 = c0749a.f15857a;
                        String valueOf = String.valueOf(bVar.a());
                        int i6 = f15852i;
                        tbImageView3.startLoad(valueOf, 24, i6, i6, false);
                    } else {
                        TbImageView tbImageView4 = c0749a.f15857a;
                        String str3 = musicData.img;
                        int i7 = f15852i;
                        tbImageView4.startLoad(str3, 10, i7, i7, false);
                    }
                    if (!TextUtils.isEmpty(bVar.b()) && bVar.b().equals(this.f15854f)) {
                        c0749a.f15857a.setDrawBorder(true);
                    } else {
                        c0749a.f15857a.setDrawBorder(false);
                    }
                    if (this.f15855g != i2) {
                        c0749a.f15858b.setVisibility(4);
                    } else if (c0749a.f15858b.getVisibility() == 0) {
                        c0749a.f15857a.setDrawBorder(false);
                    }
                    c0749a.f15859c.setText(musicData.name);
                } else if (itemViewType2 == 2) {
                    if (!TextUtils.isEmpty(bVar.b()) && bVar.b().equals(this.f15854f)) {
                        c0749a.f15857a.setBackgroundResource(R.drawable.bg_beauty_item_choosed);
                    } else {
                        c0749a.f15857a.setBackgroundResource(R.drawable.bg_beauty_item);
                    }
                    c0749a.f15859c.setText(bVar.b());
                }
                c0749a.f15857a.setTag(bVar);
                c0749a.f15857a.setTag(R.id.record_video_effect_holder, c0749a);
                c0749a.f15857a.setOnClickListener(this);
                c0749a.f15860d = i2;
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

    public void h(List<c.a.q0.a4.l.e.c.b> list, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, list, str) == null) {
            this.f15853e = list;
            this.f15854f = str;
        }
    }

    public void i(RecordEffectLayout.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, iVar) == null) {
            this.f15856h = iVar;
        }
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, str) == null) && getCount() > 1 && getItem(1) != null && getItem(1).c() == 3 && (getItem(1).d() instanceof MusicData)) {
            ((MusicData) getItem(1).d()).img = str;
            notifyDataSetChanged();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        RecordEffectLayout.i iVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, view) == null) && view.getId() == R.id.iv_effect && (view.getTag() instanceof c.a.q0.a4.l.e.c.b)) {
            c.a.q0.a4.l.e.c.b bVar = (c.a.q0.a4.l.e.c.b) view.getTag();
            if (bVar.c() == 3 && (bVar.d() instanceof MusicData)) {
                if (view.getResources().getString(R.string.music_cloud).equals(bVar.b()) && (iVar = this.f15856h) != null) {
                    iVar.b(bVar, view.getTag(R.id.record_video_effect_holder));
                    this.f15855g = this.f15853e.indexOf(bVar);
                    this.f15854f = bVar.b();
                }
                if (!TextUtils.isEmpty(bVar.b()) && bVar.b().equals(this.f15854f)) {
                    return;
                }
                if (!bVar.b().equals(view.getResources().getString(R.string.music_cloud))) {
                    this.f15855g = this.f15853e.indexOf(bVar);
                }
            } else {
                this.f15855g = this.f15853e.indexOf(bVar);
            }
            if (bVar.c() == 2 && (bVar.d() instanceof QmFilterItem)) {
                this.f15854f = ((QmFilterItem) bVar.d()).id;
            } else {
                this.f15854f = bVar.b();
            }
            notifyDataSetChanged();
            RecordEffectLayout.i iVar2 = this.f15856h;
            if (iVar2 != null) {
                iVar2.b(bVar, view.getTag(R.id.record_video_effect_holder));
            }
        }
    }
}

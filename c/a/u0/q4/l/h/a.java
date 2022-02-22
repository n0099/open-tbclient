package c.a.u0.q4.l.h;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.a.f;
import c.a.d.f.p.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.view.cloudmusic.data.CloudMusicData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public f f21608e;

    /* renamed from: f  reason: collision with root package name */
    public List<CloudMusicData.MusicTagList.MusicList> f21609f;

    /* renamed from: g  reason: collision with root package name */
    public c f21610g;

    /* renamed from: h  reason: collision with root package name */
    public String f21611h;

    /* renamed from: c.a.u0.q4.l.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1334a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CloudMusicData.MusicTagList.MusicList f21612e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f21613f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f21614g;

        public View$OnClickListenerC1334a(a aVar, CloudMusicData.MusicTagList.MusicList musicList, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, musicList, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21614g = aVar;
            this.f21612e = musicList;
            this.f21613f = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f21614g.f21610g == null) {
                return;
            }
            this.f21614g.f21610g.onMusicChooseClick(view, this.f21612e.resource, this.f21613f);
        }
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbImageView a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f21615b;

        /* renamed from: c  reason: collision with root package name */
        public View f21616c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f21617d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f21618e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f21619f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f21620g;

        /* renamed from: h  reason: collision with root package name */
        public View f21621h;

        public b() {
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

        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                SkinManager.setViewTextColor(this.f21617d, R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.f21618e, R.color.CAM_X0107);
                SkinManager.setViewTextColor(this.f21619f, R.color.CAM_X0107);
                SkinManager.setViewTextColor(this.f21620g, R.color.CAM_X0302);
                SkinManager.setBackgroundResource(this.f21620g, R.drawable.bg_music_choose);
                SkinManager.setBackgroundColor(this.f21621h, R.color.CAM_X0204);
                SkinManager.setImageResource(this.f21615b, R.drawable.btn_icon_play_video_n);
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface c {
        void onMusicChooseClick(View view, String str, int i2);
    }

    public a(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f21611h = "";
        this.f21608e = fVar;
        this.f21609f = new ArrayList();
    }

    public void b(List<CloudMusicData.MusicTagList.MusicList> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || list == null) {
            return;
        }
        for (CloudMusicData.MusicTagList.MusicList musicList : list) {
            if (!this.f21609f.contains(musicList)) {
                this.f21609f.add(musicList);
            }
        }
        notifyDataSetChanged();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: c */
    public CloudMusicData.MusicTagList.MusicList getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? this.f21609f.get(i2) : (CloudMusicData.MusicTagList.MusicList) invokeI.objValue;
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f21611h = str;
        }
    }

    public void e(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            this.f21610g = cVar;
        }
    }

    public void f(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            getItem(i2).isLoading = z;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f21609f.size() : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                view = LayoutInflater.from(this.f21608e.getPageActivity()).inflate(R.layout.cloud_music_item, viewGroup, false);
                bVar = new b();
                bVar.f21615b = (TbImageView) view.findViewById(R.id.music_state);
                TbImageView tbImageView = (TbImageView) view.findViewById(R.id.music_image);
                bVar.a = tbImageView;
                tbImageView.setDrawerType(1);
                bVar.a.setIsRound(true);
                bVar.a.setDefaultResource(R.drawable.bg_video_cloudmusic);
                bVar.a.setDefaultBgResource(R.color.transparent);
                bVar.a.setBorderWidth(n.f(this.f21608e.getPageActivity(), R.dimen.ds4));
                bVar.a.setBorderColor(SkinManager.getColor(R.color.CAM_X0302));
                bVar.a.setConrers(15);
                bVar.f21616c = view.findViewById(R.id.music_loading);
                bVar.f21617d = (TextView) view.findViewById(R.id.music_title);
                bVar.f21618e = (TextView) view.findViewById(R.id.music_author_name);
                bVar.f21619f = (TextView) view.findViewById(R.id.music_duration);
                bVar.f21620g = (TextView) view.findViewById(R.id.music_choose);
                bVar.f21621h = view.findViewById(R.id.line);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            bVar.b(TbadkCoreApplication.getInst().getSkinType());
            CloudMusicData.MusicTagList.MusicList musicList = this.f21609f.get(i2);
            if (musicList != null) {
                bVar.f21617d.setText(musicList.name);
                bVar.a.startLoad(musicList.image, 10, false);
                bVar.f21618e.setText(musicList.author);
                bVar.f21619f.setText(StringHelper.stringForVideoTime(musicList.duration * 1000));
                if (musicList.isLoading) {
                    bVar.f21616c.setVisibility(0);
                } else {
                    bVar.f21616c.setVisibility(4);
                }
                if (musicList.equals(c.a.u0.q4.l.i.a.b().a())) {
                    bVar.f21615b.setImageResource(R.drawable.btn_icon_stop_video);
                    bVar.a.setDrawBorder(true);
                    bVar.f21620g.setVisibility(0);
                    bVar.f21616c.setVisibility(4);
                    musicList.isLoading = false;
                    bVar.f21620g.setOnClickListener(new View$OnClickListenerC1334a(this, musicList, i2));
                } else if (c.a.u0.q4.l.i.a.b().a() == null && getItem(i2) != null && !TextUtils.isEmpty(this.f21611h) && this.f21611h.equals(String.valueOf(getItem(i2).music_id))) {
                    bVar.f21615b.setImageResource(R.drawable.btn_icon_play_video_n);
                    bVar.a.setDrawBorder(true);
                    bVar.f21620g.setVisibility(8);
                    bVar.f21616c.setVisibility(4);
                    musicList.isLoading = false;
                } else {
                    bVar.f21615b.setImageResource(R.drawable.btn_icon_play_video_n);
                    bVar.a.setDrawBorder(false);
                    bVar.f21620g.setVisibility(8);
                }
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}

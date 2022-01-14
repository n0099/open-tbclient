package c.a.t0.n4.l.h;

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
    public f f19940e;

    /* renamed from: f  reason: collision with root package name */
    public List<CloudMusicData.MusicTagList.MusicList> f19941f;

    /* renamed from: g  reason: collision with root package name */
    public c f19942g;

    /* renamed from: h  reason: collision with root package name */
    public String f19943h;

    /* renamed from: c.a.t0.n4.l.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1253a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CloudMusicData.MusicTagList.MusicList f19944e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f19945f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f19946g;

        public View$OnClickListenerC1253a(a aVar, CloudMusicData.MusicTagList.MusicList musicList, int i2) {
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
            this.f19946g = aVar;
            this.f19944e = musicList;
            this.f19945f = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f19946g.f19942g == null) {
                return;
            }
            this.f19946g.f19942g.onMusicChooseClick(view, this.f19944e.resource, this.f19945f);
        }
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbImageView a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f19947b;

        /* renamed from: c  reason: collision with root package name */
        public View f19948c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f19949d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f19950e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f19951f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f19952g;

        /* renamed from: h  reason: collision with root package name */
        public View f19953h;

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
                SkinManager.setViewTextColor(this.f19949d, R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.f19950e, R.color.CAM_X0107);
                SkinManager.setViewTextColor(this.f19951f, R.color.CAM_X0107);
                SkinManager.setViewTextColor(this.f19952g, R.color.CAM_X0302);
                SkinManager.setBackgroundResource(this.f19952g, R.drawable.bg_music_choose);
                SkinManager.setBackgroundColor(this.f19953h, R.color.CAM_X0204);
                SkinManager.setImageResource(this.f19947b, R.drawable.btn_icon_play_video_n);
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
        this.f19943h = "";
        this.f19940e = fVar;
        this.f19941f = new ArrayList();
    }

    public void b(List<CloudMusicData.MusicTagList.MusicList> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || list == null) {
            return;
        }
        for (CloudMusicData.MusicTagList.MusicList musicList : list) {
            if (!this.f19941f.contains(musicList)) {
                this.f19941f.add(musicList);
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
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? this.f19941f.get(i2) : (CloudMusicData.MusicTagList.MusicList) invokeI.objValue;
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f19943h = str;
        }
    }

    public void e(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            this.f19942g = cVar;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f19941f.size() : invokeV.intValue;
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
                view = LayoutInflater.from(this.f19940e.getPageActivity()).inflate(R.layout.cloud_music_item, viewGroup, false);
                bVar = new b();
                bVar.f19947b = (TbImageView) view.findViewById(R.id.music_state);
                TbImageView tbImageView = (TbImageView) view.findViewById(R.id.music_image);
                bVar.a = tbImageView;
                tbImageView.setDrawerType(1);
                bVar.a.setIsRound(true);
                bVar.a.setDefaultResource(R.drawable.bg_video_cloudmusic);
                bVar.a.setDefaultBgResource(R.color.transparent);
                bVar.a.setBorderWidth(n.f(this.f19940e.getPageActivity(), R.dimen.ds4));
                bVar.a.setBorderColor(SkinManager.getColor(R.color.CAM_X0302));
                bVar.a.setConrers(15);
                bVar.f19948c = view.findViewById(R.id.music_loading);
                bVar.f19949d = (TextView) view.findViewById(R.id.music_title);
                bVar.f19950e = (TextView) view.findViewById(R.id.music_author_name);
                bVar.f19951f = (TextView) view.findViewById(R.id.music_duration);
                bVar.f19952g = (TextView) view.findViewById(R.id.music_choose);
                bVar.f19953h = view.findViewById(R.id.line);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            bVar.b(TbadkCoreApplication.getInst().getSkinType());
            CloudMusicData.MusicTagList.MusicList musicList = this.f19941f.get(i2);
            if (musicList != null) {
                bVar.f19949d.setText(musicList.name);
                bVar.a.startLoad(musicList.image, 10, false);
                bVar.f19950e.setText(musicList.author);
                bVar.f19951f.setText(StringHelper.stringForVideoTime(musicList.duration * 1000));
                if (musicList.isLoading) {
                    bVar.f19948c.setVisibility(0);
                } else {
                    bVar.f19948c.setVisibility(4);
                }
                if (musicList.equals(c.a.t0.n4.l.i.a.b().a())) {
                    bVar.f19947b.setImageResource(R.drawable.btn_icon_stop_video);
                    bVar.a.setDrawBorder(true);
                    bVar.f19952g.setVisibility(0);
                    bVar.f19948c.setVisibility(4);
                    musicList.isLoading = false;
                    bVar.f19952g.setOnClickListener(new View$OnClickListenerC1253a(this, musicList, i2));
                } else if (c.a.t0.n4.l.i.a.b().a() == null && getItem(i2) != null && !TextUtils.isEmpty(this.f19943h) && this.f19943h.equals(String.valueOf(getItem(i2).music_id))) {
                    bVar.f19947b.setImageResource(R.drawable.btn_icon_play_video_n);
                    bVar.a.setDrawBorder(true);
                    bVar.f19952g.setVisibility(8);
                    bVar.f19948c.setVisibility(4);
                    musicList.isLoading = false;
                } else {
                    bVar.f19947b.setImageResource(R.drawable.btn_icon_play_video_n);
                    bVar.a.setDrawBorder(false);
                    bVar.f19952g.setVisibility(8);
                }
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}

package c.a.r0.k0.b;

import android.text.TextUtils;
import c.a.r0.k0.b.a;
import c.a.y0.r.n;
import c.a.y0.r.u;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.coreExtra.data.TbMultiMediaData;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.VideoMuxerData;
import com.baidu.ugc.editvideo.muxer.VideoMuxer;
import com.baidu.ugc.editvideo.player.AudioPlayData;
import com.baidu.ugc.editvideo.player.AudioPlayTrackData;
import com.baidu.ugc.utils.FileUtils;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class c implements c.a.r0.k0.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<String> a;

    /* renamed from: b  reason: collision with root package name */
    public d f18636b;

    /* renamed from: c  reason: collision with root package name */
    public a.InterfaceC1163a f18637c;

    /* renamed from: d  reason: collision with root package name */
    public TbPageContext f18638d;

    /* renamed from: e  reason: collision with root package name */
    public VideoMuxer f18639e;

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f18640f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f18641g;

    /* loaded from: classes2.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(c cVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            this.a.g();
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f18642e;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18642e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MessageManager.getInstance().unRegisterListener(this.f18642e.f18640f);
            }
        }
    }

    /* renamed from: c.a.r0.k0.b.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1164c implements c.a.y0.e.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        /* renamed from: c.a.r0.k0.b.c$c$a */
        /* loaded from: classes2.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ CustomResponsedMessage f18643e;

            public a(C1164c c1164c, CustomResponsedMessage customResponsedMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1164c, customResponsedMessage};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f18643e = customResponsedMessage;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    MessageManager.getInstance().dispatchResponsedMessage(this.f18643e);
                }
            }
        }

        public C1164c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // c.a.y0.e.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // c.a.y0.e.b
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                u.a().post(new a(this, new CustomResponsedMessage(2921584, Integer.valueOf(i2))));
            }
        }

        @Override // c.a.y0.e.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                u.a().post(this.a.f18641g);
                if (this.a.f18637c != null) {
                    this.a.f18637c.a();
                }
            }
        }

        @Override // c.a.y0.e.b
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                u.a().post(this.a.f18641g);
                if (this.a.f18637c != null) {
                    this.a.f18637c.c(str);
                }
            }
        }

        @Override // c.a.y0.e.b
        public void e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                u.a().post(this.a.f18641g);
                if (this.a.f18637c != null) {
                    this.a.f18637c.a();
                }
            }
        }

        @Override // c.a.y0.e.b
        public void f() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.a.f18637c == null) {
                return;
            }
            this.a.f18637c.b();
        }
    }

    /* loaded from: classes2.dex */
    public class d extends BdAsyncTask<List<String>, Void, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<String> a;

        /* renamed from: b  reason: collision with root package name */
        public c.a.y0.o.a f18644b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f18645c;

        /* loaded from: classes2.dex */
        public class a implements c.a.y0.o.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

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

            @Override // c.a.y0.o.a
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                }
            }

            @Override // c.a.y0.o.a
            public void b(long j2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
                }
            }

            @Override // c.a.y0.o.a
            public void onUpdateProgress(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                }
            }
        }

        public d(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18645c = cVar;
            this.f18644b = new a(this);
        }

        /* JADX WARN: Code restructure failed: missing block: B:48:0x010d, code lost:
            if (c.a.y0.r.x.h(r6, r7[0], r1, r5.f18644b) != false) goto L18;
         */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00bf  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x011d A[LOOP:0: B:52:0x0117->B:54:0x011d, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:56:0x012f A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:57:0x0130 A[RETURN] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final String b(StringBuilder sb, List<String>[] listArr) {
            InterceptResult invokeLL;
            List<String> list;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeLL = interceptable.invokeLL(1048576, this, sb, listArr)) != null) {
                return (String) invokeLL.objValue;
            }
            if (listArr[0] == null || listArr[0].size() == 0) {
                if (sb != null) {
                    sb.append("拍摄视频页需要拼接文件列表为空");
                    return null;
                }
                return null;
            }
            String str = c.a.r0.l4.c.f18986f + "rec_tmp_" + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION;
            if (!StringUtils.isNull(str)) {
                File file = new File(str);
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
            }
            boolean z2 = true;
            try {
                if (listArr[0].size() == 1) {
                    try {
                        z = c.a.r0.k4.c.b(listArr[0].get(0), str, this.f18644b);
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        if (sb != null) {
                            sb.append(e2.toString());
                        }
                        if (FileHelper.CheckFile(listArr[0].get(0))) {
                            list = listArr[0];
                        }
                        z = false;
                        if (!z) {
                        }
                        while (r6.hasNext()) {
                        }
                        if (z2) {
                        }
                    } catch (Exception e3) {
                        if (sb != null) {
                            sb.append(e3.toString());
                        }
                        if (FileHelper.CheckFile(listArr[0].get(0))) {
                            list = listArr[0];
                        }
                        z = false;
                        if (!z) {
                        }
                        while (r6.hasNext()) {
                        }
                        if (z2) {
                        }
                    }
                    if (!z && FileHelper.CheckFile(listArr[0].get(0))) {
                        list = listArr[0];
                        str = list.get(0);
                        z = true;
                    }
                    if (!z) {
                        boolean isExists = FileUtils.isExists(listArr[0].get(0));
                        if (sb != null) {
                            sb.append(" 源文件存在 ： ");
                            sb.append(isExists);
                            sb.append(" , 拍摄视频页不需要拼接时复制失败 from ");
                            sb.append(listArr[0].get(0));
                            sb.append("to ");
                            sb.append(str);
                        }
                        z2 = false;
                    }
                    for (String str2 : listArr[0]) {
                        this.f18645c.a.add(str2);
                    }
                    return z2 ? str : "";
                }
            } catch (Throwable th) {
                if (FileHelper.CheckFile(listArr[0].get(0))) {
                    listArr[0].get(0);
                }
                throw th;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                cancel(true);
                if (this.f18645c.f18637c != null) {
                    this.f18645c.f18637c.a();
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                super.onCancelled();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                if (this.f18645c.f18637c != null) {
                    this.f18645c.f18637c.b();
                }
                super.onPreExecute();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(List<String>... listArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, listArr)) == null) {
                if (ListUtils.isEmpty(listArr[0])) {
                    return "";
                }
                if (this.a == null) {
                    this.a = new ArrayList();
                }
                this.a.clear();
                this.a.addAll(listArr[0]);
                Iterator<String> it = this.a.iterator();
                while (it.hasNext()) {
                    if (c.a.y0.n.a.a(it.next()) <= 0) {
                        return "";
                    }
                }
                return b(new StringBuilder(), listArr);
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
                super.onPostExecute((d) str);
                c.a.y0.o.a aVar = this.f18644b;
                if (aVar != null) {
                    aVar.a();
                }
                if (this.f18645c.f18637c != null) {
                    this.f18645c.f18637c.c(str);
                }
            }
        }

        public /* synthetic */ d(c cVar, a aVar) {
            this(cVar);
        }
    }

    public c(TbPageContext tbPageContext, a.InterfaceC1163a interfaceC1163a) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, interfaceC1163a};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
        this.f18640f = new a(this, 2921585);
        this.f18641g = new b(this);
        this.f18638d = tbPageContext;
        this.f18637c = interfaceC1163a;
    }

    @Override // c.a.r0.k0.b.a
    public boolean a(c.a.r0.k0.b.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
            if (bVar == null) {
                return false;
            }
            int f2 = bVar.f();
            int e2 = bVar.e();
            VideoMuxerData videoMuxerData = new VideoMuxerData();
            videoMuxerData.setCompat(true);
            videoMuxerData.setRecordConfigEncodeHevcVideo(true);
            videoMuxerData.setCurrentEncodeHevcVideo(true);
            ArrayList arrayList = new ArrayList();
            if (bVar.c() != null) {
                TbMultiMediaData tbMultiMediaData = (TbMultiMediaData) bVar.c().clone();
                tbMultiMediaData.textureId = 0;
                arrayList.add(tbMultiMediaData);
                videoMuxerData.setPhotoDataList(arrayList);
                videoMuxerData.setVideoPath(tbMultiMediaData.path);
                videoMuxerData.setPreviewWidth(f2);
                videoMuxerData.setPreviewHeight(e2);
                videoMuxerData.setVideoRatio(bVar.g());
                videoMuxerData.setOutWidth(f2);
                videoMuxerData.setOutHeight(e2);
                videoMuxerData.setOutBitRate(f2 * e2 * 6);
            }
            if (bVar.a() != null) {
                videoMuxerData.setFilterValue(bVar.a());
            }
            if (bVar.b() != null) {
                videoMuxerData.setCurrThemeEffect(bVar.b());
            }
            videoMuxerData.setUserNewAudioMixture(true);
            if (bVar.d() != null) {
                videoMuxerData.setMusicData(bVar.d());
                ArrayList arrayList2 = new ArrayList();
                AudioPlayTrackData audioPlayTrackData = new AudioPlayTrackData();
                AudioPlayData audioPlayData = new AudioPlayData(bVar.d().localPath, 0, n.f(bVar.d().localPath), 1.0f);
                ArrayList arrayList3 = new ArrayList();
                audioPlayTrackData.mAudioPlayDataList = arrayList3;
                arrayList3.add(audioPlayData);
                arrayList2.add(audioPlayTrackData);
                videoMuxerData.setAudioPlayTrackDataList(arrayList2);
            }
            videoMuxerData.setComposeNecessary(true);
            VideoMuxer videoMuxer = this.f18639e;
            if (videoMuxer != null) {
                videoMuxer.interruptProcess();
            }
            VideoMuxer videoMuxer2 = new VideoMuxer();
            this.f18639e = videoMuxer2;
            videoMuxer2.setListener(new C1164c(this));
            MessageManager.getInstance().registerListener(this.f18640f);
            this.f18639e.startMuxer(videoMuxerData);
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.r0.k0.b.a
    public boolean b(List<String> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return false;
            }
            if (FileHelper.getAvailableSize() < 52428800) {
                BdToast.c(this.f18638d.getPageActivity(), this.f18638d.getResources().getString(R.string.low_memory)).q();
                return false;
            }
            d dVar = this.f18636b;
            if (dVar != null) {
                dVar.cancel();
            }
            if (h(list)) {
                d dVar2 = new d(this, null);
                this.f18636b = dVar2;
                dVar2.execute(list);
            } else {
                BdToast.c(this.f18638d.getPageActivity(), this.f18638d.getResources().getString(R.string.low_record_time_tips)).q();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            d dVar = this.f18636b;
            if (dVar != null) {
                dVar.cancel();
            }
            VideoMuxer videoMuxer = this.f18639e;
            if (videoMuxer != null) {
                videoMuxer.interruptProcess();
            }
        }
    }

    public final boolean h(List<String> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, list)) == null) {
            float f2 = 0.0f;
            for (int i2 = 0; i2 < list.size(); i2++) {
                String str = list.get(i2);
                if (!TextUtils.isEmpty(str)) {
                    f2 += n.f(str);
                }
            }
            return f2 >= 3000.0f;
        }
        return invokeL.booleanValue;
    }
}

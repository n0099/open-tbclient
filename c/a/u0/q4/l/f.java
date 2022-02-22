package c.a.u0.q4.l;

import com.baidu.tieba.view.cloudmusic.data.CloudMusicData;
/* loaded from: classes8.dex */
public interface f {
    void displayLoadingMore(boolean z);

    void displayNoDataView(boolean z);

    void displayNoMore();

    void downloadCancel(int i2);

    void downloadError(int i2);

    void setPresenter(e eVar);

    void showMusicListData(CloudMusicData.MusicTagList musicTagList);

    void showMusicLoading(int i2);
}

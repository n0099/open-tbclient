package c.a.r0.c4.k;

import com.baidu.tieba.view.cloudmusic.data.CloudMusicData;
/* loaded from: classes3.dex */
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

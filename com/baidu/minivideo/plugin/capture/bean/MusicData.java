package com.baidu.minivideo.plugin.capture.bean;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public class MusicData extends MusicBaseBean implements Serializable {
    public static final int CATEGORY_RECOMMEND = 1;
    public static final int CATEGORY_SEARCH = 2;
    public static final String MUSIC_DATA_KEY = "musicdata";
    private static final long serialVersionUID = -2120437114458663204L;
    public String authorUk;
    public String bgSound;
    public int category;
    public String collectStatus;
    public String duration;
    public String ext;
    public String icon;
    public String id;
    public boolean isFollow;
    public String localPath;
    public String localTransCodePath;
    public int mProgress;
    public String musicAuthor;
    public String musicName;
    public int rate;
    public String singer;
    public long size;
    public String sk;
    public String soundSrc;
    public int startPosition;
    public String title;
    public String url;
    public String what;
    public boolean mIsUsing = false;
    public boolean mIsPlaying = false;
    public float mVolume = 1.0f;

    public MusicData() {
        this.type = MusicStyle.COMMON.value();
    }

    public static MusicData parse(String str) {
        MusicData musicData;
        Exception e;
        JSONObject jSONObject;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            jSONObject = new JSONObject(str);
            musicData = new MusicData();
        } catch (Exception e2) {
            musicData = null;
            e = e2;
        }
        try {
            musicData.id = jSONObject.optString("music_id");
            musicData.title = jSONObject.optString("music_title");
            musicData.singer = jSONObject.optString("music_singer");
            musicData.icon = jSONObject.optString("music_icon");
            musicData.url = jSONObject.optString("music_url");
            musicData.localPath = jSONObject.optString("music_local_path");
            musicData.sk = jSONObject.optString("sk");
            musicData.ext = jSONObject.optString("ext");
            musicData.startPosition = jSONObject.optInt("start_position");
            musicData.localTransCodePath = jSONObject.optString("music_local_transcode_path");
            musicData.isFollow = jSONObject.optInt("is_follow") == 1;
            musicData.authorUk = jSONObject.optString("author_uk");
            musicData.musicName = jSONObject.optString("music_name");
            musicData.musicAuthor = jSONObject.optString("music_author");
            musicData.soundSrc = jSONObject.optString("sound_src");
            musicData.bgSound = jSONObject.optString("bg_sound");
            musicData.mVolume = (float) jSONObject.optDouble("volume", 1.0d);
            musicData.collectStatus = jSONObject.optString("collect_status");
            musicData.mProgress = jSONObject.optInt("progress");
            return musicData;
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            return musicData;
        }
    }

    public static String toJSON(MusicData musicData) {
        if (musicData == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("music_id", musicData.id);
            jSONObject.put("music_title", musicData.title);
            jSONObject.put("music_singer", musicData.singer);
            jSONObject.put("music_icon", musicData.icon);
            jSONObject.put("music_url", musicData.url);
            jSONObject.put("music_local_path", musicData.localPath);
            jSONObject.put("sk", musicData.sk);
            jSONObject.put("ext", musicData.ext);
            jSONObject.put("start_position", musicData.startPosition);
            jSONObject.put("music_local_transcode_path", musicData.localTransCodePath);
            jSONObject.put("is_follow", musicData.isFollow ? 1 : 0);
            jSONObject.put("author_uk", musicData.authorUk);
            jSONObject.put("sound_src", musicData.soundSrc);
            jSONObject.put("bg_sound", musicData.bgSound);
            jSONObject.put("music_name", musicData.musicName);
            jSONObject.put("music_author", musicData.musicAuthor);
            jSONObject.put("volume", musicData.mVolume);
            jSONObject.put("collect_status", musicData.collectStatus);
            jSONObject.put("progress", musicData.mProgress);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static MusicCategoryBean parseNetArray(JSONObject jSONObject) {
        MusicCategoryBean musicCategoryBean = new MusicCategoryBean();
        ArrayList<MusicBaseBean> arrayList = new ArrayList<>();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("musicList");
            if (jSONArray != null && jSONArray.length() > 0) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    MusicData parseNetBean = parseNetBean(jSONArray.getJSONObject(i));
                    if (parseNetBean != null) {
                        parseNetBean.category = 2;
                        arrayList.add(parseNetBean);
                    }
                }
                if (arrayList.size() > 0) {
                    musicCategoryBean.mCategory = 2;
                }
            }
            if (arrayList.size() == 0) {
                JSONArray jSONArray2 = jSONObject.getJSONArray("recommendList");
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    MusicData parseNetBean2 = parseNetBean(jSONArray2.getJSONObject(i2));
                    if (parseNetBean2 != null) {
                        parseNetBean2.category = 1;
                        arrayList.add(parseNetBean2);
                    }
                }
                if (arrayList.size() > 0) {
                    musicCategoryBean.mCategory = 1;
                }
            }
        } catch (JSONException e) {
            arrayList.clear();
        }
        musicCategoryBean.list = arrayList;
        return musicCategoryBean;
    }

    public static MusicCategoryBean parseNetCollectArray(JSONObject jSONObject) {
        MusicCategoryBean musicCategoryBean = new MusicCategoryBean();
        ArrayList<MusicBaseBean> arrayList = new ArrayList<>();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("musicList");
            if (jSONArray != null && jSONArray.length() > 0) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    MusicData parseNetBean = parseNetBean(jSONArray.getJSONObject(i));
                    if (parseNetBean != null) {
                        parseNetBean.category = 2;
                        arrayList.add(parseNetBean);
                    }
                }
                if (arrayList.size() > 0) {
                    musicCategoryBean.mCategory = 2;
                }
            }
        } catch (JSONException e) {
            arrayList.clear();
        }
        musicCategoryBean.list = arrayList;
        return musicCategoryBean;
    }

    public static MusicData parseNetBean(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        MusicData musicData = new MusicData();
        musicData.id = jSONObject.optString("id");
        musicData.icon = jSONObject.optString("cover");
        musicData.title = jSONObject.optString("name");
        musicData.singer = jSONObject.optString("singer");
        musicData.duration = jSONObject.optString("duration");
        musicData.collectStatus = jSONObject.optString("collect_status");
        return musicData;
    }

    @Override // com.baidu.minivideo.plugin.capture.bean.MusicBaseBean
    public int getSpanSize() {
        return 4;
    }

    public long getMusicDuration() {
        long j = 0;
        try {
            if (!TextUtils.isEmpty(this.duration)) {
                String[] split = this.duration.split(":");
                if (split.length == 1) {
                    j = Long.parseLong(split[0]) * 1000;
                } else if (split.length == 2) {
                    j = ((Long.parseLong(split[0]) * 60) + Long.parseLong(split[1])) * 1000;
                } else if (split.length == 3) {
                    j = ((Long.parseLong(split[0]) * 3600) + Long.parseLong(split[2]) + (Long.parseLong(split[1]) * 60)) * 1000;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return j;
    }
}

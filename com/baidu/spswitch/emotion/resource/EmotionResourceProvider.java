package com.baidu.spswitch.emotion.resource;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.io.FileUtils;
import com.baidu.spswitch.utils.SPConfig;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class EmotionResourceProvider implements IResourceProvider {
    public static final boolean DEBUG = SPConfig.isDebug();
    public static final String EMOTION_CONFIG_NAME = "emotion_info.json";
    public static final String EMOTION_RES_NAME_SUFFIX = ".png";
    public static final String EMOTION_SOUND_SUFFIX = ".mp3";
    public static final String TAG = "EmotionResourceProvider";
    public Context mContext;
    public String mEmotionConfigInfo = "";
    public Map<String, File> mEmotionIconFileMap = new HashMap();
    public File mEmotionSoundFile;
    public File mResourcePath;

    /* loaded from: classes3.dex */
    public static class Builder {
        public static final String DEFAULT_UNZIP_DIR_NAME = "emotion_unzip";
        public Context mContext;
        public File mProcessedResPath;
        public EmotionResourceProvider mProvider;
        public File mUnZipOutputPath;
        public File mZipInputPath;

        public Builder(Context context) {
            this.mContext = context;
        }

        private void releaseProvider() {
            EmotionResourceProvider emotionResourceProvider = this.mProvider;
            if (emotionResourceProvider == null) {
                return;
            }
            emotionResourceProvider.releaseResource();
        }

        public IResourceProvider build() {
            boolean z;
            if (this.mProcessedResPath != null) {
                releaseProvider();
                this.mProvider = new EmotionResourceProvider(this.mContext, this.mProcessedResPath);
            } else {
                File file = this.mZipInputPath;
                if (file == null || this.mUnZipOutputPath == null) {
                    if (EmotionResourceProvider.DEBUG) {
                        Log.d(EmotionResourceProvider.TAG, "build failed, ZipInputPath or UnZipOutputPath is empty");
                    }
                    return null;
                }
                try {
                    z = FileUtils.unzipFile(file.getPath(), this.mUnZipOutputPath.getPath());
                } catch (Exception unused) {
                    z = false;
                }
                if (!z) {
                    if (EmotionResourceProvider.DEBUG) {
                        Log.d(EmotionResourceProvider.TAG, "build failed, failed to unzip, src:" + this.mZipInputPath.getPath() + ", dest:" + this.mUnZipOutputPath.getPath());
                    }
                    return null;
                }
                releaseProvider();
                this.mProvider = new EmotionResourceProvider(this.mContext, this.mUnZipOutputPath);
            }
            return this.mProvider;
        }

        public Builder setProcessedResourcePath(String str) {
            File file = new File(str);
            this.mProcessedResPath = file;
            if (!file.exists()) {
                this.mProcessedResPath = null;
            }
            return this;
        }

        public Builder setUnZipOutputPath(String str) {
            File file = new File(str);
            this.mUnZipOutputPath = file;
            if (!file.exists()) {
                this.mUnZipOutputPath.mkdirs();
            }
            return this;
        }

        public Builder setZipInputPath(String str) {
            File file = new File(str);
            this.mZipInputPath = file;
            if (file.exists() && FileUtils.isZipFile(this.mZipInputPath)) {
                if (this.mUnZipOutputPath == null) {
                    setUnZipOutputPath(this.mZipInputPath.getParent() + File.separator + DEFAULT_UNZIP_DIR_NAME);
                }
            } else {
                this.mZipInputPath = null;
            }
            return this;
        }
    }

    public EmotionResourceProvider(Context context, File file) {
        this.mResourcePath = file;
        this.mContext = context;
    }

    private void clearAll() {
        this.mEmotionIconFileMap.clear();
        this.mEmotionConfigInfo = "";
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:17:0x0038 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.BufferedReader] */
    private void getEmotionConfigInfo(File file) {
        FileInputStream fileInputStream;
        IOException e2;
        BufferedReader bufferedReader;
        if (file == null || !file.exists()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        ?? r1 = 0;
        r1 = 0;
        try {
            try {
                try {
                    fileInputStream = new FileInputStream(file);
                } catch (Throwable th) {
                    th = th;
                    r1 = file;
                }
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, "utf-8"));
                    try {
                        for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                            sb.append(readLine);
                        }
                        bufferedReader.close();
                        fileInputStream.close();
                    } catch (IOException e3) {
                        e2 = e3;
                        e2.printStackTrace();
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        this.mEmotionConfigInfo = sb.toString();
                    }
                } catch (IOException e4) {
                    e2 = e4;
                    bufferedReader = null;
                } catch (Throwable th2) {
                    th = th2;
                    if (r1 != 0) {
                        try {
                            r1.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                            throw th;
                        }
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw th;
                }
            } catch (IOException e6) {
                fileInputStream = null;
                e2 = e6;
                bufferedReader = null;
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
            }
        } catch (IOException e7) {
            e7.printStackTrace();
        }
        this.mEmotionConfigInfo = sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isFilteredResDir(File file, String... strArr) {
        if (file != null && strArr != null) {
            String lowerCase = TextUtils.isEmpty(file.getName()) ? "" : file.getName().toLowerCase();
            for (String str : strArr) {
                if (lowerCase.indexOf(TextUtils.isEmpty(str) ? "" : str.toLowerCase()) != -1) {
                    return true;
                }
            }
        }
        return false;
    }

    private void searchEmotionConfig(File file) {
        File[] listFiles;
        if (file == null || !file.exists() || (listFiles = file.listFiles(new FileFilter() { // from class: com.baidu.spswitch.emotion.resource.EmotionResourceProvider.2
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                return !file2.isDirectory() && EmotionResourceProvider.this.isFilteredResDir(file2, "emotion_info.json");
            }
        })) == null || listFiles.length <= 0) {
            return;
        }
        getEmotionConfigInfo(listFiles[0]);
    }

    private void searchEmotionIcon(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        file.listFiles(new FileFilter() { // from class: com.baidu.spswitch.emotion.resource.EmotionResourceProvider.3
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                if (file2.isDirectory() || !EmotionResourceProvider.this.isFilteredResDir(file2, EmotionResourceProvider.EMOTION_RES_NAME_SUFFIX)) {
                    return false;
                }
                EmotionResourceProvider.this.mEmotionIconFileMap.put(file2.getName(), file2);
                return true;
            }
        });
    }

    private void searchEmotionSound(File file) {
        File[] listFiles;
        if (file == null || !file.exists() || (listFiles = file.listFiles(new FileFilter() { // from class: com.baidu.spswitch.emotion.resource.EmotionResourceProvider.1
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                return !file2.isDirectory() && EmotionResourceProvider.this.isFilteredResDir(file2, EmotionResourceProvider.EMOTION_SOUND_SUFFIX);
            }
        })) == null || listFiles.length <= 0) {
            return;
        }
        this.mEmotionSoundFile = listFiles[0];
    }

    @Override // com.baidu.spswitch.emotion.resource.IResourceProvider
    public String getEmotionConfigContent() {
        return this.mEmotionConfigInfo;
    }

    @Override // com.baidu.spswitch.emotion.resource.IResourceProvider
    public File getEmotionIconResFile(String str) {
        return this.mEmotionIconFileMap.get(str);
    }

    @Override // com.baidu.spswitch.emotion.resource.IResourceProvider
    public File getEmotionSoundFile() {
        return this.mEmotionSoundFile;
    }

    @Override // com.baidu.spswitch.emotion.resource.IResourceProvider
    public void loadResource() {
        synchronized (this) {
            clearAll();
            searchEmotionConfig(this.mResourcePath);
            searchEmotionIcon(this.mResourcePath);
            searchEmotionSound(this.mResourcePath);
        }
    }

    @Override // com.baidu.spswitch.emotion.resource.IResourceProvider
    public void releaseResource() {
        clearAll();
    }
}

package com.baidu.searchbox.wordscommand.runtime;

import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.wordscommand.WordCommandManager;
import com.baidu.searchbox.wordscommand.data.CommandContent;
import com.baidu.searchbox.wordscommand.listener.PictureCommandInvokeCallBack;
/* loaded from: classes4.dex */
public interface IWordCommandApp {
    public static final IWordCommandApp EMPTY = new IWordCommandApp() { // from class: com.baidu.searchbox.wordscommand.runtime.IWordCommandApp.1
        @Override // com.baidu.searchbox.wordscommand.runtime.IWordCommandApp
        public boolean canPreloadSwanApp(String str) {
            return false;
        }

        @Override // com.baidu.searchbox.wordscommand.runtime.IWordCommandApp
        public void getPictureCommandContent(String str, PictureCommandInvokeCallBack pictureCommandInvokeCallBack) {
        }

        @Override // com.baidu.searchbox.wordscommand.runtime.IWordCommandApp
        public void handlePreloadSwanApp() {
        }

        @Override // com.baidu.searchbox.wordscommand.runtime.IWordCommandApp
        public boolean isMainProcess() {
            return true;
        }

        @Override // com.baidu.searchbox.wordscommand.runtime.IWordCommandApp
        public boolean isNewInstall() {
            return false;
        }

        @Override // com.baidu.searchbox.wordscommand.runtime.IWordCommandApp
        public void schemeInvoke(String str) {
        }

        @Override // com.baidu.searchbox.wordscommand.runtime.IWordCommandApp
        public void doOnShowParseCommandDialogWithPopupExclusion(Context context, CommandContent commandContent) {
            WordCommandManager.getInstance().doOnShowParseCommandDialog(context, commandContent, new DialogInterface.OnDismissListener() { // from class: com.baidu.searchbox.wordscommand.runtime.IWordCommandApp.1.1
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                }
            }, new DialogInterface.OnShowListener() { // from class: com.baidu.searchbox.wordscommand.runtime.IWordCommandApp.1.2
                @Override // android.content.DialogInterface.OnShowListener
                public void onShow(DialogInterface dialogInterface) {
                }
            });
        }
    };
    public static final String LOG_TAG = "IWordCommandApp";

    boolean canPreloadSwanApp(String str);

    void doOnShowParseCommandDialogWithPopupExclusion(Context context, CommandContent commandContent);

    void getPictureCommandContent(String str, PictureCommandInvokeCallBack pictureCommandInvokeCallBack);

    void handlePreloadSwanApp();

    boolean isMainProcess();

    boolean isNewInstall();

    void schemeInvoke(String str);

    /* loaded from: classes4.dex */
    public static final class Impl {
        public static IWordCommandApp sWordCommandApp = WordCommandRuntime.getWordCommandApp();

        @NonNull
        public static IWordCommandApp get() {
            if (sWordCommandApp == null) {
                Log.w(IWordCommandApp.LOG_TAG, "Fetch IWordCommandApp implementation failed, IWordCommandApp.EMPTY applied");
                sWordCommandApp = IWordCommandApp.EMPTY;
            }
            return sWordCommandApp;
        }
    }
}

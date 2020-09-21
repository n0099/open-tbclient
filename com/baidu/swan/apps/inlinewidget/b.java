package com.baidu.swan.apps.inlinewidget;

import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.swan.apps.inlinewidget.d;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public abstract class b<W extends d> implements ZeusPlugin {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected ZeusPlugin.Callback cvr;
    @NonNull
    protected W cvs;
    private boolean cvt = false;
    private final List<ZeusPlugin.Command> cvu = new ArrayList();
    private d.a cvv = new d.a() { // from class: com.baidu.swan.apps.inlinewidget.b.1
        @Override // com.baidu.swan.apps.inlinewidget.d.a
        public void ep(boolean z) {
            synchronized (b.this) {
                if (b.DEBUG) {
                    Log.i("BaseInlineController", "组件初始化完成，开始flush挂起的指令=====");
                }
                b.this.aou();
                b.this.cvt = true;
                if (b.DEBUG) {
                    Log.i("BaseInlineController", "指令flush完成=========================");
                }
            }
        }
    };
    protected c<W> cvq = new c<>();

    public b(@NonNull W w) {
        this.cvs = w;
        if (DEBUG) {
            Log.i("BaseInlineController", "开始初始化组件");
        }
        this.cvs.a(this.cvv);
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPlugin
    public void setCallback(ZeusPlugin.Callback callback) {
        this.cvr = callback;
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPlugin
    public void sendCommand(ZeusPlugin.Command command) {
        synchronized (this) {
            if (command != null) {
                if (this.cvt) {
                    if (DEBUG) {
                        Log.v("BaseInlineController", "组件已初始化，直接尝试分发Command: + " + command.what);
                    }
                    this.cvq.b(command, this.cvs);
                } else {
                    ZeusPlugin.Command command2 = new ZeusPlugin.Command();
                    command2.what = command.what;
                    command2.arg1 = command.arg1;
                    command2.arg2 = command.arg2;
                    command2.arg3 = command.arg3;
                    command2.arg4 = command.arg4;
                    command2.arg5 = command.arg5;
                    command2.obj = command.obj;
                    this.cvu.add(command2);
                    if (DEBUG) {
                        Log.i("BaseInlineController", "组件未初始化，加入Pending队列： " + command2.what);
                    }
                    this.cvq.a(command);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aou() {
        if (this.cvu.size() != 0) {
            Iterator<ZeusPlugin.Command> it = this.cvu.iterator();
            while (it.hasNext()) {
                ZeusPlugin.Command next = it.next();
                if (DEBUG) {
                    Log.i("BaseInlineController", "flush-尝试分发Command: + " + next.what);
                }
                this.cvq.b(next, this.cvs);
                it.remove();
            }
        }
    }
}
